import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    static int max = Integer.MIN_VALUE;
    static List<Integer> countList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                String input = st.nextToken();
                map[i][j] = Integer.parseInt(input);
            }
        }

        dfs(0);

        int maxSafeCount = countList
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();

        System.out.println(maxSafeCount);

    }

    private static void dfs(int count) {
        if (count == 3) {
            bfs(Arrays.stream(map)
                    .map(int[]::clone)
                    .toArray(int[][]::new));
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs(int[][] array) {
        int count = 0;


        Queue<Direction> directions = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 2) {
                    directions.add(new Direction(i, j));
                }
            }
        }

        while (!directions.isEmpty()) {
            Direction poll = directions.poll();
            for (int i = 0; i < 4; i++) {
                int y = poll.y + dirY[i];
                int x = poll.x + dirX[i];
                if (y >= 0 && x >= 0 && y < N && x < M && array[y][x] == 0) {
                    array[y][x] = 2;
                    directions.add(new Direction(y, x));
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    count++;
                }
            }
        }
        countList.add(count);


    }


}


class Direction {

    public int y;
    public int x;

    public Direction(int y, int x) {
        this.y = y;
        this.x = x;
    }


}













