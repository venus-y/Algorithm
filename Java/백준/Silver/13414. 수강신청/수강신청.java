import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int K;
  static int L;
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    Map<String, Integer> stuNumMap = new HashMap<>();
    String stuNum;
    for (int i = 0; i < L; i++) {
      stuNum = br.readLine();
      stuNumMap.put(stuNum, i);
    }
    String[] stuNumArr = new String[L];

    int limitCount = 0;
    for (Map.Entry<String, Integer> entry : stuNumMap.entrySet()) {
      stuNumArr[entry.getValue()] = entry.getKey();
    }

    for (int i = 0; i < stuNumArr.length; i++) {
      if (stuNumArr[i] != null && stuNumMap.get(stuNumArr[i]) == i) {
        System.out.println(stuNumArr[i]);
        limitCount++;
      }
      if (limitCount == K) {
        break;
      }


    }

  }


}





