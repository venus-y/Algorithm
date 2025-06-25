import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static int solution(int[][] routes) {
    // 자동차의 진입점, 진출점을 기준으로 오름차순 정렬한다.
    Arrays.sort(routes,
        Comparator.comparingInt(r -> r[1])                 // r[0] 오름차순
    );
    // 현재자동차의 진출점이 다음 자동차의 진입, 진출점 이내에 있을 경우 카메라 개수를 증가시키지 않는다.
    // 현재자동차의 진출점이 다음 자동차의 진입, 진출점 이내에 있지 않을 경우 카메라 개수를 증가시키고
    // 기준치가 되는 자동차의 진출점을 현재자동차의 진출점으로 갱신한다.

    // 기준이 되는 자동차 진출점
    int startOutPos = routes[0][1];

    // 자동차가 1대만 지나다닐 경우 1 반환
    if (routes.length == 1) {
      return 1;
    }

    // 필요한 카메라 개수
    int answer = 1;

    for (int i = 1; i < routes.length; i++) {
      int[] route = routes[i];
      if (route[0] <= startOutPos && route[1] >= startOutPos) {
        continue;
      }
      // startOutPos에 있는 카메라로 감지가 불가능할 경우 카메라를 새로 세팅하고 카운트를 증가시킨다.
      startOutPos = route[1];
      answer++;
    }

    return answer;
  }
}