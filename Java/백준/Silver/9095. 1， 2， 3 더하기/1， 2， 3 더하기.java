import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static int N;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    provideInputNumber(N, br);

  }

  private static void provideInputNumber(int n, BufferedReader br) throws IOException {

    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(br.readLine());
      calculator(input);
    }
  }

  private static void calculator(int input) {
    if (input == 1) {
      System.out.println(1);
      return;
    }
    if (input == 2) {
      System.out.println(2);
      return;
    }
    if (input == 3) {
      System.out.println(4);
      return;
    }
    int[] dp = new int[input + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i < dp.length; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    System.out.println(dp[input]);
  }


}

