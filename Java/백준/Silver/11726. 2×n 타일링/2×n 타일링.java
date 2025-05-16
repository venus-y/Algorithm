import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
  public static int N;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    System.out.println(fibonacciMod(N+1, 10007));

  }

  public static int bitwiseAdd(int a, int b) {
    while (b != 0) {
      int carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }
    return a;
  }

  public static int fibonacciMod(int n, int mod) {
    int a = 0;
    int b = 1;
    if (n == 0) return 0;
    if (n == 1) return 1;

    int result = 1;
    for (int i = 2; i <= n; i++) {
      result = bitwiseAdd(a, b) % mod;
      a = b;
      b = result;
    }
    return result;
  }
}