import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int n;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      Map<String, Integer> sortingMap = new HashMap<>();
      int inputCount = Integer.parseInt(br.readLine());

      if (inputCount == 0) {
        System.out.println(0);
        continue;
      }
      StringTokenizer st;
      for (int j = 0; j < inputCount; j++) {
        st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        String sort = st.nextToken();
        sortingMap.put(sort, sortingMap.getOrDefault(sort, 0) + 1);
      }
      int possibleSituation = 1;
      Set<String> keySet = sortingMap.keySet();
      if (keySet.size() == 1) {
        for (String key : keySet) {
          System.out.println(sortingMap.get(key));
        }
      } else {
        for (String key : keySet) {
          possibleSituation *= sortingMap.get(key) + 1;
        }
        System.out.println(possibleSituation - 1);

      }
      
    }

  }


}