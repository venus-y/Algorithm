import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  public static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String parsedNumberString = br.readLine();
    Character[] charArray = new Character[parsedNumberString.length()];
    for (int i = 0; i < parsedNumberString.length(); i++) {
      charArray[i] = parsedNumberString.charAt(i);
    }
    boolean containsZero = false;
    int sum = 0;
    for (Character c : charArray) {
      if (c - '0' == 0) {
        containsZero = true;
      }
      sum += c - '0';
    }
    if (sum % 3 == 0 && containsZero) {
      Arrays.sort(charArray, Collections.reverseOrder());
      StringBuilder sb = new StringBuilder();
      for (Character character : charArray) {
        sb.append(character);
      }
      System.out.println(sb);
    } else {
      System.out.println(-1);
    }


  }


}

