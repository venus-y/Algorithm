class Solution {
    public static int solution(String name) {
    String comparedString = "A".repeat(name.length());
    if (comparedString.equals(name)) {
      return 0;
    }

    int answer = 0;
    int turnPoint = Integer.MAX_VALUE;

    for (int i = 0; i < name.length(); i++) {
      char c = name.charAt(i);
      answer += Math.min(c - 'A', 26 - (c - 'A'));
    }

    for (int i = 0; i < name.length(); i++) {
      int n = name.length();
      int next = i + 1;
      while (next < n && name.charAt(next) == 'A') {
        next++;
      }
      int phasedTurnPoint = Math.min(2 * i + (name.length() - next),
          i + (2 * (name.length() - next)));
      turnPoint = Math.min(turnPoint, phasedTurnPoint);
    }

    return answer + turnPoint;
  }
}