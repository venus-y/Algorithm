class Solution {
    public static int solution(int[][] triangle) {
    int[][] sum = new int[501][501];

    // 삼각형의 높이가 1층일 경우 1층의 값을 반환
    if (triangle.length == 1) {
      return triangle[0][0];
    }
    // 삼각형의 높이가 2층일 경우 1층+2층의 각 원소합 중 더 큰 값을 반환
    if (triangle.length == 2) {
      return Math.max(triangle[0][0] + triangle[1][0], triangle[0][0] + triangle[1][1]);
    }
    // 2층의 사이드 값 초기화
    sum[1][0] = triangle[0][0] + triangle[1][0];
    sum[1][1] = triangle[0][0] + triangle[1][1];
    // 3층부터는 양 사이드 수의 경우 이전층의 사이드 수를 더한 값으로 세팅한다.
    for (int i = 2; i < triangle.length; i++) {
      sum[i][0] = sum[i - 1][0] + triangle[i][0];
      sum[i][i] = sum[i - 1][i - 1] + triangle[i][i];
      // 이전층의 왼쪽과 오른쪽 중 더 큰 값을 현재 층의 위치의 값과 더한다.
      for (int j = 1; j < i; j++) {
        sum[i][j] = Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + triangle[i][j];
      }
    }

    int answer = 0;

    for (int value : sum[triangle.length - 1]) {
      answer = Math.max(answer, value);
    }
    return answer;
  }
}