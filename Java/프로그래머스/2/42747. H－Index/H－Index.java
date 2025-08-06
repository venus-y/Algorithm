import java.util.*;




class Solution {
    public static int solution(int[] citations) {
    // 배열 오름차순 정렬
    Arrays.sort(citations);
    // 배열의 [i]번쨰 요소의 값이 앞으로 순회할 남은 요소들의 개수보다 크거나 같을 경우 그 지점이 hIndex가 된다
    for (int i = 0; i < citations.length; i++) {
      int hIndex = citations.length - i;
      if (citations[i] >= hIndex) {
        return hIndex;
      }
    }
    return 0;
  }
}