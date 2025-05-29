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
  public static char[][] maps;
  public static boolean[][] visited;
  public static int[] dirY = {-1, 1, 0, 0};
  public static int[] dirX = {0, 0, 1, -1};
  public static int blueScore = 0;
  public static int whiteScore = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    maps = new char[M][N];
    visited = new boolean[M][N];

    for (int i = 0; i < M; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        maps[i][j] = input.charAt(j);
      }
    }

    for (int i = 0; i < maps.length; i++) {
      for (int j = 0; j < maps[i].length; j++) {
        if (!visited[i][j]) {
          visited[i][j] = true;
          bfs(i, j);
        }
      }
    }
    System.out.print(whiteScore + " " + blueScore);

  }

  public static void bfs(int y, int x) {
    // 현재 색깔과 동일한 색깔들을 탐색한 후 방문표시한다.
    Queue<Direction> queue = new LinkedList<>();
    queue.add(new Direction(y, x));
    char sign = maps[y][x];
    int colorCount = 1;
    while (!queue.isEmpty()) {
      Direction d = queue.poll();
      for (int i = 0; i < 4; i++) {
        int newY = d.y + dirY[i];
        int newX = d.x + dirX[i];
        if ((newY >= 0 && newX >= 0) && (newY < M && newX < N) && (!visited[newY][newX])
            && maps[newY][newX] == sign) {
          visited[newY][newX] = true;
          queue.add(new Direction(newY, newX));
          colorCount++;
        }
      }
    }
    if (sign == 'W') {
      whiteScore += (int) Math.pow(colorCount, 2);
    } else {
      blueScore += (int) Math.pow(colorCount, 2);
    }

  }

  public static class Direction {

    public int y;
    public int x;

    public Direction(int y, int x) {
      this.y = y;
      this.x = x;
    }

  }


}

