import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static int N;
  public static int L;
  public static StringTokenizer st;
  public static int[] numbers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    numbers = new int[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    Deque<Integer> deque = new ArrayDeque<>();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < numbers.length; i++) {
      if (!deque.isEmpty() && deque.peekFirst() < i - L + 1) {
        deque.pollFirst();
      }
      while (!deque.isEmpty() && numbers[deque.peekLast()] > numbers[i]) {
        deque.pollLast();
      }
      deque.addLast(i);
      bw.write(numbers[deque.peekFirst()] + " ");
    }

    bw.flush();
    bw.close();

  }


}

