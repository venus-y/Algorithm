import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static StringTokenizer st;
  static boolean[] visited;
  static int[] results;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];
    results = new int[N + 1];
    dfs(0);
    System.out.println(sb);
  }

  public static void dfs(int depth) {
    if (depth == M) {

      StringBuilder numberStore = new StringBuilder();

      for (int i = 0; i < results.length; i++) {
        if (results[i] != 0) {
          numberStore.append(results[i]);
        }
      }
      for (int i = 0; i < numberStore.length(); i++) {
        sb.append(numberStore.charAt(i)).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (depth > 0 && results[depth - 1] > i) {
        continue;
      }
      results[depth] = i;
      dfs(depth + 1);
    }
  }
}






