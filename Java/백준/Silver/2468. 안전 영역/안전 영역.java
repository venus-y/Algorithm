
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] check;
    static int[][] map;

    static int answer = 0;

    static Integer maxHeight = 0;

    static Integer minHeight = Integer.MAX_VALUE;

    static int count = 0;

    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        map = new int[size][size];
        check = new boolean[size][size];


        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        for (int i = 0; i <= maxHeight; i++) {
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map[j].length; k++) {
                    if (map[j][k] > i && !check[j][k]) {
                        dfs(i, j, k);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
            count = 0;
            check = new boolean[size][size];
        }

        System.out.println(answer);

    }

    public static void dfs(int height, int y, int x) {
        check[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nY = dirY[i] + y;
            int nX = dirX[i] + x;
            if (nY >= 0 && nY < map.length && nX >= 0 && nX < map[0].length && !check[nY][nX] && map[nY][nX] > height) {
                dfs(height, nY, nX);
            }
        }
    }


}



