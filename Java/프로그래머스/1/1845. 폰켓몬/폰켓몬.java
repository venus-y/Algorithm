import java.util.HashSet;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> poketmons = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (poketmons.size() == nums.length / 2) {
                break;
            }
            poketmons.add(nums[i]);
        }
        return poketmons.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 1, 2, 3};
        System.out.println(sol.solution(nums)); // Example usage
    }
}





    



