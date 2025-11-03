import java.io.BufferedReader;
import java.io.InputStreamReader;
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
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];
    results = new int[N + 1];
//    for (int i = 1; i <= M; i++) {
//      numberMap.put(i, new ArrayList<>());
//    }
    dfs(0);
    System.out.println(sb);
  }

  public static void dfs(int depth) {
    if (depth == M) {
//      List<String> numbers = numberMap.get(depth);
      int checkCount = 0;

      StringBuilder numberStore = new StringBuilder();

      for (int i = 0; i < results.length; i++) {
        if (results[i] != 0) {
          numberStore.append(results[i]);
        }
      }
      String uniqueNumber = numberStore.toString();
//      for (String num : numbers) {
//        for (int i = 0; i < num.length(); i++) {
//          if (numberStore.charAt(i) == num.charAt(i)) {
//            checkCount++;
//          }
//        }
//        if (checkCount == M) {
//          return;
//        }
//        checkCount = 0;
//      }
//
//      numbers.add(uniqueNumber);
      for (int i = 0; i < numberStore.length(); i++) {
        sb.append(numberStore.charAt(i)).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      results[depth] = i;
      dfs(depth + 1);
    }
  }
}






