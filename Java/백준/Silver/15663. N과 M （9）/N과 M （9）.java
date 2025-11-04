import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static StringTokenizer st;
  static int[] results;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();
  static Map<Integer, Set<String>> uniqueNumberMap = new HashMap<>();
  static ArrayList<Integer> numbers = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(numbers);
    results = new int[N + 1];
    visited = new boolean[10000 + 1];
    uniqueNumberMap.put(M, new HashSet<>());
    dfs(0);
    System.out.print(sb);
  }

  public static void dfs(int depth) {
    if (depth == M) {
      Set<String> uniqueNumberSet = uniqueNumberMap.get(M);
      StringBuilder numberStore = new StringBuilder();
      for (int num : results) {
        if (num != 0) {
          numberStore.append(num).append(" ");
        }
      }
      String numberStoreString = numberStore.toString();
      if (!uniqueNumberSet.contains(numberStoreString)) {
        sb.append(numberStoreString);
        sb.append("\n");
      }
      uniqueNumberSet.add(numberStoreString);
      return;
    }
    for (int i = 0; i < numbers.size(); i++) {
      if (!visited[i]) {
        visited[i] = true;
        results[depth] = numbers.get(i);
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }
}









