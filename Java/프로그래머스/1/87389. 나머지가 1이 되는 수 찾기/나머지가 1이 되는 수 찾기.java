class Solution {
    public static int solution(int n) {
        int mod = 0;

        for(int i=n; i>0; i--){
            if(n % i == 1)
                mod = i;
        }
        return mod;
    }
}