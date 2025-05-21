import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static int T;
  public static int k;
  public static int n;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      k = Integer.parseInt(br.readLine());
      n = Integer.parseInt(br.readLine());

      int[][] apartment = new int[k + 1][n + 1];

      for (int j = 1; j < n + 1; j++) {
        apartment[0][j] = j;
      }

      for (int j = 1; j < k + 1; j++) {
        for (int k = 1; k < n + 1; k++) {
          for (int l = 1; l <= k; l++) {
            apartment[j][k] += apartment[j - 1][l];
          }
        }
      }
      System.out.println(apartment[k][n]);
    }
  }


}

