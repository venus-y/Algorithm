import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static StringTokenizer st;
  public static int aCount;
  public static int currentACount;
  public static int exchangeCount;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    String input = st.nextToken();
    // 입력받은 문자열을 문자 배열로 전환
    char[] alphabets = input.toCharArray();
    // 문자를 담을 큐
    Deque<Character> alphabetQueue = new ArrayDeque<>();
    // 문자열 내 a의 개수를 파악
    for (int i = 0; i < alphabets.length; i++) {
      if (alphabets[i] == 'a') {
        aCount++;
      }
    }
    // a의 개수만큼 슬라이딩 윈도우의 크기를 설정
    // 슬라이딩 윈도우 초기화
    for (int i = 0; i < aCount; i++) {
      alphabetQueue.add(alphabets[i]);
      if (alphabets[i] == 'a') {
        currentACount++;
      }
    }

    // a로만 이루어져있을 경우
    if (aCount == alphabets.length) {
      System.out.println(0);
      return;
    }
    // b로만 이루어져있을 경우
    if (aCount == 0) {
      System.out.println(0);
      return;
    }
    // a가 하나일 경우
    if (aCount == 1) {
      System.out.println(0);
      return;
    }

    // 최소교환횟수를 초기화
    exchangeCount = aCount - currentACount;

    for (int i = 1; i < alphabets.length; i++) {
      if (alphabetQueue.isEmpty()) {
        break;
      }
      Character c = alphabetQueue.pollFirst();
      // 앞에서 제거한 문자가 a일 경우 카운트 감소
      if (c == 'a') {
        currentACount--;
      }
      // 윈도우가 문자열의 길이를 초과할 경우 -1 을 한 후 % 결과로 위치를 정한다.
      if (i + aCount >= alphabets.length) {
        char newAlphabet = alphabets[(i + aCount - 1) % alphabets.length];
        if (newAlphabet == 'a') {
          currentACount++;
        }
        alphabetQueue.add(newAlphabet);
        // 최소 교환 횟수 갱신
        exchangeCount = Math.min(exchangeCount, aCount - currentACount);
        continue;
      }
      int i1 = (i + aCount) % alphabets.length;
      char newAlphabet = alphabets[(i + aCount - 1) % alphabets.length];
      if (newAlphabet == 'a') {
        currentACount++;
      }
      alphabetQueue.add(newAlphabet);
      // 최소 교환 횟수 갱신
      exchangeCount = Math.min(exchangeCount, aCount - currentACount);
    }

    System.out.println(exchangeCount);
  }


}

