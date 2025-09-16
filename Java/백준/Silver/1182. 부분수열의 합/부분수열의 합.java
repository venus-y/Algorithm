import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int S;
  static StringTokenizer st;
  static int[] numbers;
  static int count;
  static int sum;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    // 입력받을 수의 총 길이
    N = Integer.parseInt(st.nextToken());
    // 부분수열의 합과 같은지 확인하는 타겟넘버
    S = Integer.parseInt(st.nextToken());
    // 배열의 크기를 초기화
    numbers = new int[N];
    st = new StringTokenizer(br.readLine());
    // 배열을 초기화
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    // 배열의 첫번쨰 요소부터 마지막 요소까지 차례로 순회하며 dfs 진행
    // 첫번쨰 요소의 dfs는 첫번쨰 요소 ~ 끝 요소까지 포함, 미포함 여부를 분기처리하여 진행
    // 두번째 요소의 dfs는 첫번째 요소를 제외한 끝 요소까지 포함, 미포함 여부를 분기처리
    dfs(0, 0);

    if (S == 0) {
      count--;
    }

    System.out.println(count);


  }

  public static void dfs(int idx, int sum) {
    if (idx == N) {
      if (sum == S) {
        count++;
      }
      return;
    }

    dfs(idx + 1, sum + numbers[idx]);
    dfs(idx + 1, sum);
  }
}