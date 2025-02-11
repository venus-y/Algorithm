class Solution {
     public long[] solution(int x, int n) {
        long[] answers = new long[n];
        long startValue = x;
        for(int start = 0; start < n; start++, startValue+=x) {
            answers[start] = startValue;
        }
        return answers;
    }
}