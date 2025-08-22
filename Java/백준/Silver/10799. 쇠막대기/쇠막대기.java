import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 입력받은 괄호를 input에 저장한다.
    String input = br.readLine();
    // input에서 파이프에 해당하는 부분을 덱에 넣는다.
    Deque<Character> pipeStore = new ArrayDeque<>();
    int answer = 0;

    // 현재 받아온 값의 이전 값이 여는 괄호이고 현재 받아온 값이 닫힌 괄호일 경우 pipeStore에서 여는 괄호를 하나 제거한 후 pipeStore에 존재하는 열린 괄호의 개수만큼 answer에 합산한다.

    // 현재 받아온 값이 닫는 괄호이고 이전에 받아온 값 또한 닫는 괄호일 경우 pipeStore에서 여는괄호 하나를 제거하고 answer++한다.

    // 이외의 경우는 여는 괄호를 그냥 pipeStore에 저장한다.
    for (int i = 0; i < input.length(); i++) {
      // i가 0일 때는 pipeStore에 괄호를 넣고 continue한다
      if (i == 0) {
        char value = input.charAt(i);
        pipeStore.add(value);
        continue;
      } else if (input.charAt(i - 1) == '(' && input.charAt(i) == ')') {
        pipeStore.pop();
        answer += pipeStore.size();
      } else if (input.charAt(i - 1) == ')' && input.charAt(i) == ')') {
        pipeStore.pop();
        answer++;
      } else {
        pipeStore.add(input.charAt(i));
      }
    }

    System.out.println(answer);

  }

}
