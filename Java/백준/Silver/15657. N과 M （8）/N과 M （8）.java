import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static StringTokenizer st;
  static boolean[] visited;
  static int[] results;
  static StringBuilder sb = new StringBuilder();
  static Map<Integer, Set<String>> uniqueNumberMap = new HashMap<>();
  static int[] numbers;
  static int[] checkNumArr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    numbers = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(numbers);
    visited = new boolean[10000 + 1];
    results = new int[N + 1];
    uniqueNumberMap.put(M, new HashSet<>());
    dfs(0);
    System.out.print(sb);
  }

  public static void dfs(int depth) {
    if (depth == M) {
      StringBuilder numberStore = new StringBuilder();
      for (int result : results) {
        if (result != 0) {
          numberStore.append(result).append(" ");
        }
      }
      String numberStoreString = numberStore.toString();
      String[] splitedNumberStore = numberStoreString.split(" ");
      checkNumArr = new int[splitedNumberStore.length];
      Set<String> uniqueNumberSet = uniqueNumberMap.get(M);
      checkNumArr = new int[numberStore.length()];
//      if (!uniqueNumberSet.contains(numberStore.toString())) {
//        for (String s : splitedNumberStore) {
//          sb.append(s).append(" ");
//        }
//        uniqueNumberSet.add(numberStore.toString());
      sb.append(numberStoreString);
      sb.append("\n");
//      }
      return;
    }

    for (int number : numbers) {
      if (depth > 0 && results[depth - 1] > number) {
        continue;
      }
//      if (!visited[number]) {
      results[depth] = number;
//        visited[number] = true;
      dfs(depth + 1);
//        visited[number] = false;
//      }
    }
  }
}







