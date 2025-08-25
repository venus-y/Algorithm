import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] numbers = new int[N];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N + 1];

    if (N == 1) {
      System.out.println(numbers[0]);
      return;
    }

    dp[1] = numbers[0];
    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.max(dp[i - 1] + numbers[i - 1], numbers[i - 1]);
    }

    int max = Integer.MIN_VALUE;

    for (int i = 1; i < dp.length; i++) {
      max = Math.max(dp[i], max);
    }

    System.out.println(max);

  }

}
