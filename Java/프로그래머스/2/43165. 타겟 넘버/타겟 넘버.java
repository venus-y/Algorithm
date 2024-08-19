class Solution {

    static int answer = 0;


    public int solution(int[] numbers, int target) {
        dfs(numbers[0], target, 0, numbers, 0);

        return answer;
    }

    public void dfs(int num, int targetNum, int sum, int numbers[], int count) {

        if (count == numbers.length) {
            if (sum == targetNum) {
                answer++;
            }
            return;
        } else {
            dfs(count + 1, targetNum, sum + numbers[count], numbers, count + 1);
            dfs(count + 1, targetNum, sum - numbers[count], numbers, count + 1);

        }

    }
}




