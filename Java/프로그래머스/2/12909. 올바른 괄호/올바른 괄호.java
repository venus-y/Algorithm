import java.util.Stack;


class Solution {
   public static boolean solution(String s) {
    // 괄호를 담을 stack 생성
    Stack<Character> characters = new Stack<>();
    // 문자열을 문자 배열로 변환
    char[] charArray = s.toCharArray();
    // 문자 배열을 순회하며 스택에 삽입하거나 pop을 수행
    for (int i = 0; i < charArray.length; i++) {
      char c = charArray[i];
      // 입력받은 것이 여는 괄호인 경우는 그냥 쌓는다
      if (c == '(') {
        characters.add(c);
        continue;
      }
      // 스택의 꼭대기가 여는 괄호이고 현재 입력받은 것이 닫는 괄호일 경우 stack.pop
      if (!characters.isEmpty() && characters.peek() == '(' && c == ')') {
        characters.pop();
        continue;
      }
      // 스택의 꼭대기가 비어있거나 꼭대기의 요소가 닫는 괄호이고 입력받은 것이 닫는 괄호일 경우 그냥 넣는다.
      if (characters.isEmpty() || characters.peek() == ')') {
        characters.add(c);
      }
    }

    if (characters.isEmpty()) {
      return true;
    }
    return false;
  }
}