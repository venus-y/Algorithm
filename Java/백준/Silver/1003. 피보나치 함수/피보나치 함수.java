import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static int T;
  public static int N;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      N = Integer.parseInt(br.readLine());
      if (N == 0) {
        System.out.println("1 0");
        continue;
      }
      if (N == 1) {
        System.out.println("0 1");
        continue;
      }
      if (N == 2) {
        System.out.println("1 1");
        continue;
      }
      int dp[] = new int[N + 1];
      dp[1] = 1;
      dp[2] = 1;
      dp[3] = 2;
      for (int j = 4; j < dp.length; j++) {
        dp[j] = dp[j - 1] + dp[j - 2];
      }
      System.out.println(dp[N - 1] + " " + dp[N]);
    }
  }


}

