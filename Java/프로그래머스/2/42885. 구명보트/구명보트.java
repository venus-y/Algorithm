import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;


class Solution {
    public static  int solution(int[] people, int limit) {
    // 구명보트에 탄 사람들의 무게를 데큐에 넣는다
    List<Integer> weightList = new ArrayList<>();
    for (int i = 0; i < people.length; i++) {
      weightList.add(people[i]);
    }
    // 무게의 오름차순으로 정렬한다.
    Collections.sort(weightList);
    Deque<Integer> weightDeque = new ArrayDeque<>(weightList);
    int count = 0;
    // 첫번째 사람과 마지막 사람의 무게의 합이 한계치를 초과하지 않을 경우 두 명을 동시에 구출하고 count를 증가시킨다
    // 만약 두 사람의 무게합이 한계치를 초과할 경우 마지막사람만 구출하고 count를 증가시킨다
    // 한명만 남았을 경우는 한명만 구출시키고 종료
    while (!weightDeque.isEmpty()) {
      if (weightDeque.peekFirst() + weightDeque.peekLast() > limit) {
        weightDeque.pollLast();
        count++;
      } else if (weightDeque.peekFirst() + weightDeque.peekLast() <= limit) {
        weightDeque.pollFirst();
        weightDeque.pollLast();
        count++;
      }
    }

    return count;
  }
}