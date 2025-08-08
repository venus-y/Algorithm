import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
    public static int solution(int N, int number) {
    // 만약 N과 number가 동일하다면 1을 즉시 return
    if (N == number) {
      return 1;
    }
    // N을 사용할 수 있는 경우의 수를 1~8까지 순차적으로 구한다.
    // N을 사용한 횟수를 기록하는 Set과, Set을 저장할 List를 생성
    List<Set<Integer>> records = new ArrayList<>();
    // N을 한번 사용한 경우는 미리 초기화한다.
    // 1번 인덱스부터 사용하기 위해 0번 인덱스는 빈 셋으로 채운다
    records.add(new HashSet<>());
    Set<Integer> firstNumber = new HashSet<>();
    firstNumber.add(N);
    records.add(firstNumber);
    // 3부터 8까지 N을 사용하는 경우의 수를 모두 구한다.
    for (int i = 2; i <= 8; i++) {
      Set<Integer> numbers = new HashSet<>();
      // 매 순회마다 N을 이어붙인 형태를 Set에 추가 ex) N=2 -> 22
      String parsedFromNumber = Integer.toString(N);
      numbers.add(Integer.parseInt(parsedFromNumber.repeat(i)));
      // j < i 까지의 조건으로 반복문을 수행
      // j가 1일 때 i가 2라면 records의  i-j에 해당하는 위치에 존재하는 Set을 가져온 후 records의 j의 위치하는 Set과 수행할 수 있는 사칙연산의 경우의 수를 구한다.
      // 구한 값을 Set에 넣어 records의 i의 위치에 삽입한다.
      for (int j = 1; j < i; j++) {
        Set<Integer> numbers1 = records.get(i - j);
        Set<Integer> numbers2 = records.get(j);
        for (Integer num1 : numbers1) {
          for (Integer num2 : numbers2) {
            numbers.add(num1 + num2);
            numbers.add(num1 - num2);
            numbers.add(num1 * num2);
            if (num1 != 0 && num2 != 0) {
              numbers.add(num1 / num2);
            }
          }
        }
      }
      records.add(numbers);
    }

    for (int i = 2; i < records.size(); i++) {
      Set<Integer> numbers = records.get(i);
      for (Integer num : numbers) {
        if (num == number) {
          return i;
        }
      }
    }
    return -1;
  }
}