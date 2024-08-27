import java.io.IOException;
import java.util.ArrayList;

class Solution {
    static ArrayList<Integer>[] arrayLists;
    static boolean[] checkArr;

    
    public static int solution(int n, int[][] computers) throws IOException {

        int answer = 0;

        arrayLists = new ArrayList[n + 1];

        checkArr = new boolean[n + 1];

        for (int i = 1; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] != 0 && i != j) {
                    arrayLists[i + 1].add(j + 1);
                }
            }
        }

        for (int i = 1; i < arrayLists.length; i++) {
            if (!checkArr[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int cpu) {
        checkArr[cpu] = true;

        for (int i = 0; i < arrayLists[cpu].size(); i++) {
            if (!checkArr[arrayLists[cpu].get(i)]) {
                dfs(arrayLists[cpu].get(i));
            }
        }

    }
}