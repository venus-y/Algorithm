import java.io.IOException;

class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
    // 체육복을 잃어버린 사람과, 체육복 여벌을 갖고 있는 사람을 boolean 배열로 체크한다.
    boolean[] lostCheckArr = new boolean[n + 1];
    boolean[] reserveCheckArr = new boolean[n + 1];

    for (int i = 0; i < reserve.length; i++) {
      reserveCheckArr[reserve[i]] = true;
    }
    for (int i = 0; i < lost.length; i++) {
      // 도난당한 사람이 여벌체육복을 보유하지 않을 경우 도난당한 사람으로 간주한다.
      if (!reserveCheckArr[lost[i]]) {
        lostCheckArr[lost[i]] = true;
      }
      // 도난당했지만 여벌체육복이 있을 경우 여벌체육복 보유여부를 false로만 변경한다.
      else {
        reserveCheckArr[lost[i]] = false;
      }
    }

    for (int i = 1; i <= n; i++) {
      // i번 학생이 체육복을 도난당했을 경우
      if (lostCheckArr[i]) {
        // i번 학생이 1번째 학생일 경우
        if (i == 1) {
          // 자신의 오른쪽에 있는 학생이 체육복을 도난당하지 않았으면서 여벌 체육복을 가지고 있는지 확인
          if (reserveCheckArr[i + 1]) {
            // 오른쪽 학생에게 체육복을 빌리고 해당 학생의 여벌 체육복 보유여부를 false로 변경하고 자신의 체육복 도난여부를 false로 변경한다.
            lostCheckArr[i] = false;
            reserveCheckArr[i + 1] = false;
          }
          continue;
        }
        if (i == n) {
          // n번째 학생이 도난당했을 경우
          if (reserveCheckArr[i - 1]) {
            lostCheckArr[i] = false;
            reserveCheckArr[i - 1] = false;
          }
          continue;
        }
        // 자신의 왼쪽이나 오른쪽에 체육복을 빌려줄 수 있는 사람이 있는 경우
        if ((reserveCheckArr[i - 1])
            || reserveCheckArr[i + 1]) {
          // 왼쪽과 오른쪽에 여벌 체육복을 가진 학생이 모두 있을 경우 왼쪽 학생에게 빌린다.
          if (reserveCheckArr[i - 1] && (reserveCheckArr[i + 1])) {
            reserveCheckArr[i - 1] = false;
            lostCheckArr[i] = false;
          }
          // 둘 중 한 학생만 체육복을 가지고 있을 경우 해당 학생에게 빌린다.
          else {
            if ((reserveCheckArr[i - 1])) {
              reserveCheckArr[i - 1] = false;
            } else {
              reserveCheckArr[i + 1] = false;
            }
            lostCheckArr[i] = false;
          }
        }
      }
    }

    // 1. 1번~n번 학생까지 순차적으로 순회한다
    // 2. 현재 순회중인 학생이 체육복을 도난당했을 경우 자신의 좌우에 여벌의 체육복을 가진 학생이 있는지 확인한다.
    // 3. 2번 조건을 만족할 경우 좌우를 확인 후 좌우에 여벌의 체육복을 입은 학생이 모두 존재할 경우 좌측의 학생이 가진 체육복을 빌린다.
    // 4. 만약 한쪽만 체육복을 가지고 있을 경우 해당 학생에게 체육복을 빌린다.
    // 5. 현재 순회중인 학생이 첫번째 학생이거나 n번째 학생일 경우 3~4의 조건을 체크하지 않고 첫번째의 경우 자신의 오른쪽, n번째의 경우 자신의 왼쪽 학생에게 체육복을 빌린다.
    // 6. 체육복을 빌릴 경우 빌려주는 학생이 여벌 체육복을 도난당했는지 확인한다. 만약 도난당했을 경우 빌려줄 수 없다.
    int count = 0;
    for (int i = 1; i < lostCheckArr.length; i++) {
      if (!lostCheckArr[i]) {
        count++;
      }
    }
    return count;
  }
}