import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static StringTokenizer st;
  static boolean[] visited;
  static int[] results;
  static Map<Integer, List<String>> numberMap = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];
    results = new int[N + 1];
    for (int i = 1; i <= M; i++) {
      numberMap.put(i, new ArrayList<String>());
    }
    dfs(0);
  }

  public static void dfs(int depth) {
    if (depth == M) {
      List<String> numbers = numberMap.get(depth);
      int checkCount = 0;
      for (String num : numbers) {
        for (int result : results) {
          if (result != 0 && num.contains(Integer.toString(result))) {
            checkCount++;
          }
        }
        if (checkCount == M) {
          return;
        }
        checkCount = 0;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < results.length; i++) {
        if (results[i] != 0) {
          sb.append(results[i]);
        }
      }
      numbers.add(sb.toString());
      String uniqueNumber = sb.toString();
      for (int i = 0; i < uniqueNumber.length(); i++) {
        System.out.print(uniqueNumber.charAt(i) - '0' + " ");
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





