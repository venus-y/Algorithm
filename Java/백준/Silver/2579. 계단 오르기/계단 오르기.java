import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static int N;
  public static int maxLength;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int[] numbers = new int[N + 1];

    for (int i = 1; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
    }

    stair(numbers);
  }

  private static void stair(int[] numbers) {
    int[] dp = new int[N + 1];
    if (N == 1) {
      System.out.println(numbers[1]);
      return;
    }
    dp[1] = numbers[1];
    dp[2] = numbers[1] + numbers[2];
    if (N == 2) {
      System.out.println(dp[2]);
      return;
    }
    dp[3] = Math.max(numbers[1], numbers[2]) + numbers[3];
    if (N == 3) {
      System.out.println(dp[3]);
      return;
    }

    for (int i = 4; i < dp.length; i++) {
      dp[i] = Math.max(dp[i - 2] + numbers[i], dp[i - 3] + numbers[i - 1] + numbers[i]);
    }

    System.out.println(dp[N]);
  }


}