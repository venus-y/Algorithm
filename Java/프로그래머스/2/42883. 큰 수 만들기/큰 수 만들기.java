import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static String solution(String number, int k) {
    Deque<Integer> numbers = new ArrayDeque<>();
    // 첫번쨰 숫자를 데큐에 추가한다.
    char[] numberCharArray = number.toCharArray();
    numbers.add(Integer.parseInt(String.valueOf(numberCharArray[0] - '0')));
    // 문자열을 순회하면서 큐에 하나씩 넣는다.
    // 자신보다 작은 수는 뒤에 추가한다.
    // 자신의 앞에 있는 수가 자신보다 작을 경우 자신의 앞에 있는 수들을 순회하면서
    // 자신보다 작은 수들을 제거한다.
    // 수를 제거하게 되면 k를 감소시킨다
    // k가 0이 되었다면 더 이상 수를 제거할 수 없기 때문에 뒤에 있는 수들을 전부 이어 붙인다.
    int leftIdx = 0;
    boolean leftIndexExists = false;

    for (int i = 1; i < numberCharArray.length; i++) {
      if (numbers.peekLast() >= numberCharArray[i] - '0') {
        Integer i1 = numbers.peekLast();
        int i2 = numberCharArray[i] - '0';
        numbers.add(numberCharArray[i] - '0');
      } else if (k > 0) {
        while (true) {
          numbers.pollLast();
          k--;
          if (k == 0 || numbers.isEmpty()) {
            break;
          }
          if (numbers.peekLast() >= numberCharArray[i] - '0') {
            break;
          }
        }
        numbers.add(numberCharArray[i] - '0');
      } else if (k == 0) {
        leftIdx = i;
        leftIndexExists = true;
        break;
      }
    }

    if (k != 0) {
      while (true) {
        numbers.pollLast();
        k--;
        if (k == 0) {
          break;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (Integer i : numbers) {
      sb.append(i);
    }
    if (leftIndexExists) {
      for (int i = leftIdx; i < numberCharArray.length; i++) {
        sb.append(numberCharArray[i] - '0');
      }
    }
    
    return sb.toString();
  }
}