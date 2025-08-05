import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public static String solution(int[] numbers) {
    // 숫자들을 문자열 리스트에 담는다.
    List<String> parsedNumbers
        = Arrays.stream(numbers)
        .mapToObj(Integer::toString)
        .collect(Collectors.toList());

    parsedNumbers.sort((a, b) -> (b + a).compareTo(a + b));

    if (parsedNumbers.get(0).equals("0")) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();

    parsedNumbers.forEach(sb::append);
    return sb.toString();
  }
}