import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;

    static int[][] map;

    static boolean[][] check;

    static int count = 0;

    static int[] dirY = {-1, 1, 0, 0};

    static int[][] dp;

    static int[] dirX = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        check = new boolean[m][n];
        dp = new int[m][n];

        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(dp[0][0]);

    }

    private static void dfs(int y, int x) {

        if (y == m - 1 && x == n - 1) {
            dp[y][x] = 1;
            return;
        }


        if (dp[y][x] != -1) {
            return;
        }

        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int nY = dirY[i] + y;
            int nX = dirX[i] + x;
            if (0 <= nY && nY < m && 0 <= nX && nX < n && map[y][x] > map[nY][nX]) {
                dfs(nY, nX);
                dp[y][x] += dp[nY][nX];
            }
        }
    }

}

