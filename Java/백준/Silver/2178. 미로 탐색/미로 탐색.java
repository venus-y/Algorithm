import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int N;
  public static int M;
  public static StringTokenizer st;
  public static boolean[][] visited;
  public static int[][] miro;
  public static int[][] scoreBoard;
  public static int[] dirY = {-1, 1, 0, 0};
  public static int[] dirX = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N][M];
    miro = new int[N][M];
    scoreBoard = new int[N][M];
    scoreBoard[0][0] = 1;

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < M; j++) {
        miro[i][j] = input.charAt(j) - '0';
      }
    }

    bfs(0, 0);
    System.out.println(scoreBoard[N - 1][M - 1]);

  }

  public static void bfs(int y, int x) {
    // 시작점을 큐에 넣는다
    Queue<Direction> queue = new LinkedList<>();
    queue.add(new Direction(x, y, 1));
    visited[y][x] = true;
    scoreBoard[y][x] = 1;

    while (!queue.isEmpty()) {
      Direction direction = queue.poll();
      for (int i = 0; i < 4; i++) {
        int dy = direction.y + dirY[i];
        int dx = direction.x + dirX[i];
        if ((dy >= 0 && dx >= 0) && (dy < N && dx < M) && !visited[dy][dx] && miro[dy][dx] == 1) {
          visited[dy][dx] = true;
          scoreBoard[dy][dx] = direction.currentCount + 1;
          queue.add(new Direction(dy, dx, direction.currentCount + 1));
        }
      }
    }
  }

  public static class Direction {

    public int y;
    public int x;
    public int currentCount;

    public Direction(int y, int x, int currentCount) {
      this.y = y;
      this.x = x;
      this.currentCount = currentCount;
    }

    public Direction(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    public int getCurrentCount() {
      return currentCount;
    }
  }


}

