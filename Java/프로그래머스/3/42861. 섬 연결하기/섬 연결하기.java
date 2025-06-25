import java.util.Arrays;
import java.util.Comparator;


class Solution {
    
  public static int solution(int n, int[][] costs) {
    // 총 연결비용을 저장하는 변수
    int answer = 0;
    // 연결된 경로의 개수를 저장하는 변수
    int loadsCount = 0;

    // 이동비용을 의미하는 costs를 이동비용의 오름차순으로 정렬한다. -> 가장 적은 비용으로 경로를 설치하기 위해
    Arrays.sort(costs, Comparator.comparingInt(c -> c[2]));
    // 각 지점이 속할 그룹을 생성한 후 초기화한다
    // 1번 지점은 1번그룹, 2번 지점은 2번 그룹, n번 -> n번 그룹에 속하도록 한다.
    int[] group = new int[n];

    for (int i = 0; i < group.length; i++) {
      group[i] = i;
    }
    // costs를 순회하면서 각 지점을 이어줄지를 결정한다.
    for (int i = 0; i < costs.length; i++) {
      if (loadsCount == n - 1) {
        break;
      }

      int first = costs[i][0];
      int second = costs[i][1];

      if (find(first, group) != find(second, group)) {
        union(first, second, group);
        answer += costs[i][2];
        loadsCount++;
      }
    }

    // 두 영역이 같은 그룹에 속하지 않을 경우 union을 통해 합쳐준다.
    // 경로의 개수가 n - 1이 된 시점에서는 더 이상 경로를 추가하지 않는다.
    // 경로를 설정하려는 두 지점이 이미 같은 그룹에 속한 경우에는 경로를 설정하지 않는다.
    // 경로를 설정하였을 경우 해당 경로를 설정하는데 드는 비용을 answer에 가산한다.

    return answer;
  }

  public static int find(int pos, int[] group) {
    if (group[pos] == pos) {
      return pos;
    }
    return group[pos] = find(group[pos], group);
  }

  public static void union(int first, int second, int[] group) {

    int firstGroup = find(first, group);
    int secondGroup = find(second, group);

    group[firstGroup] = secondGroup;
  }

}