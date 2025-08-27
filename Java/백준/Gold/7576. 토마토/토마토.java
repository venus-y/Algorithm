import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

  static int[] dirY = {-1, 1, 0, 0};
  static int[] dirX = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    // 열 갯수
    int M = Integer.parseInt(st.nextToken());
    // 행 갯수
    int N = Integer.parseInt(st.nextToken());
    // 토마토 박스 배열을 생성
    int[][] tomatoBox = new int[N][M];
    // tomatoBox에 토마토 배치 정보를 담는다.
    for (int i = 0; i < tomatoBox.length; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < tomatoBox[i].length; j++) {
        tomatoBox[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // tomatoBox에서 익은 토마토 + 익지 않은 토마토 - 토마토가 없는 칸을 제외한 갯수 == 토마토 박스 배열에 존재하는 익은 토마토의 개수 << 이 경우는 익을 토마토가 없다는 의미이므로 0을 출력
    // 익은 토마토의 개수를 카운팅하는 변수
    int grainedTomatoCnt = 0;
    // 익지 않은 토마토의 개수를 카운팅하는 변수
    int notGrainedTomatoCnt = 0;
    // 토마토가 없는 칸의 개수를 카운팅하는 변수
    int notExistsCnt = 0;

    for (int i = 0; i < tomatoBox.length; i++) {
      for (int j = 0; j < tomatoBox[i].length; j++) {
        if (tomatoBox[i][j] == 1) {
          grainedTomatoCnt++;
        } else if (tomatoBox[i][j] == -1) {
          notExistsCnt++;
        } else {
          notGrainedTomatoCnt++;
        }
      }
    }

    if ((tomatoBox.length * tomatoBox[0].length) - notExistsCnt - (grainedTomatoCnt
        - notGrainedTomatoCnt) == 0) {
      System.out.println(0);
      return;
    }

    // 토마토 박스 배열을 순회하면서 이미 익은 토마토들의 위치를 덱에 담는다.
    Deque<Position> alreadyGrainedTomatoPositions = new ArrayDeque<>();
    for (int i = 0; i < tomatoBox.length; i++) {
      for (int j = 0; j < tomatoBox[i].length; j++) {
        if (tomatoBox[i][j] == 1) {
          alreadyGrainedTomatoPositions.add(new Position(i, j));
        }
      }
    }

    // while문이 반복할 때마다 하루가 지난 것으로 간주하고 dayCount를 증가
    int dayCount = 0;
    while (!alreadyGrainedTomatoPositions.isEmpty()
        && (tomatoBox.length * tomatoBox[0].length) - notExistsCnt - (grainedTomatoCnt
        - notGrainedTomatoCnt) != 0) {
      // 새로 익힌 토마토의 위치를 저장할 리스트
      List<Position> nowGrainedPos = new ArrayList<>();
      // 기존에 저장되있던 익혀진 토마토들의 위치가 빌 때까지 순회
      while (!alreadyGrainedTomatoPositions.isEmpty()) {
        Position prevPos = alreadyGrainedTomatoPositions.pop();
        // alreadyGrainedTomatoPositions가 빌 때까지 반복하며 alreadyGrainedTomatoPositions에 저장되어 있는 위치의 상하좌우에 있는 익지 않은 토마토들을 익힌 상태로 바꾸고 다시 저장한다.
        for (int i = 0; i < 4; i++) {
          int newY = prevPos.y + dirY[i];
          int newX = prevPos.x + dirX[i];
          Position newPos = new Position(newY, newX);
          // 이미 방문한 지점은 재방문하지 않는다.

          if (newY < tomatoBox.length && newY > -1 && newX < tomatoBox[0].length && newX > -1
              && tomatoBox[newY][newX] == 0) {
            tomatoBox[newY][newX] = 1;
            nowGrainedPos.add(newPos);
            grainedTomatoCnt++;
            notGrainedTomatoCnt--;
          }
        }
      }
      alreadyGrainedTomatoPositions.addAll(nowGrainedPos);
      dayCount++;
    }

    if ((tomatoBox.length * tomatoBox[0].length) - notExistsCnt - (grainedTomatoCnt
        - notGrainedTomatoCnt) != 0) {
      System.out.println(-1);
      return;
    }

    System.out.println(dayCount);

  }

  static class Position {

    int y;
    int x;

    public Position(int y, int x) {
      this.y = y;
      this.x = x;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Position position = (Position) o;
      return y == position.y && x == position.x;
    }

    @Override
    public int hashCode() {
      return Objects.hash(y, x);
    }
  }
}