import java.util.Arrays; 

class Solution {
    public static boolean solution(String[] phone_book) {
    // 문자열 배열을 오름차순 정렬
    // 배열의 앞 요소가 뒤 요소의 접두사인지 체크
    // 맞다면 false 반환
    // 이외의 경우 true 반환
    Arrays.sort(phone_book);

    if (phone_book.length == 1) {
      return true;
    }
    for (int i = 1; i < phone_book.length; i++) {
      if (phone_book[i].startsWith(phone_book[i - 1])) {
        return false;
      }
    }
    return true;
  }
}




