import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  static int N;
  static int[] dp;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    dp = new int[N + 1];
    // 시작점의 연산횟수는 1로 초기화
    dp[N] = 0;
    // 경로를 저장할 Map에 정수, 문자열형태의 값을 저장
    // 계산횟수를 저장할 Map에 해당 정수까지의 계산횟수를 저장
    Map<Integer, Integer> countMap = new HashMap<>();
    Map<Integer, Integer> routeMap = new HashMap<>();
    countMap.put(N, 0);
    routeMap.put(N, N);

    for (int i = N; i >= 1; i--) {
      if (i % 3 == 0) {
        int dividedValue = i / 3;
        if (!countMap.containsKey(dividedValue)) {
          Integer beforeDivided = i;
          routeMap.put(dividedValue, beforeDivided);
          countMap.put(dividedValue, dp[i] + 1);
          dp[i / 3] = dp[i] + 1;
        } else {
          if (dp[i / 3] > dp[i] + 1) {
            Integer beforeDivided = i;
            routeMap.put(dividedValue, beforeDivided);
            countMap.put(dividedValue, dp[i] + 1);
            dp[i / 3] = dp[i] + 1;
          }
        }
      }
      if (i % 2 == 0) {
        int dividedValue = i / 2;
        if (!countMap.containsKey(dividedValue)) {
          Integer beforeDivided = i;
          routeMap.put(dividedValue, beforeDivided);
          countMap.put(dividedValue, dp[i] + 1);
          dp[i / 2] = dp[i] + 1;
        } else {
          if (dp[i / 2] > dp[i] + 1) {
            Integer beforeDivided = i;
            routeMap.put(dividedValue, beforeDivided);
            countMap.put(dividedValue, dp[i] + 1);
            dp[i / 2] = dp[i] + 1;
          }
        }
      }
      int minusValue = i - 1;
      if (!countMap.containsKey(minusValue)) {
        Integer beforeMinus = i;
        routeMap.put(minusValue, beforeMinus);
        countMap.put(minusValue, dp[i] + 1);
        dp[i - 1] = dp[i] + 1;
      } else {
        if (dp[i - 1] > dp[i] + 1) {
          Integer beforeMinus = i;
          routeMap.put(minusValue, beforeMinus);
          countMap.put(minusValue, dp[i] + 1);
          dp[i - 1] = dp[i] + 1;
        }
      }

    }

    int end = N;
    int start = 1;
    StringBuilder sb = new StringBuilder();
    while (start < end) {
      sb.append(start).append(" ");
      start = routeMap.get(start);
    }

    sb.append(N);

    String[] answer = sb.toString().split(" ");
    System.out.println(countMap.get(1));
    for (int i = answer.length - 1; i >= 0; i--) {
      System.out.print(answer[i] + " ");
    }


  }


}