import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static StringTokenizer st;
  static boolean[] visited;
  static int[] results;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];
    results = new int[N + 1];
    dfs(0);
  }

  public static void dfs(int depth) {
    if (depth == M) {
      for (int result : results) {
        if (result != 0) {
          System.out.print(result + " ");
        }
      }
      System.out.println();
      return;
    }
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        results[depth] = i;
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }
}





