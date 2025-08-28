import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

//  static int[] dirY = {-1, 1, 0, 0};
//  static int[] dirX = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // N == K일 경우 즉시 종료
    if (N == K) {
      System.out.println(0);
      return;
    }

    // 현재 위치를 큐에 넣는다.
    Deque<CurrentPos> currentPos = new ArrayDeque<>();
    // 방문한 위치를 재방문하지 않도록 관리
    boolean[] visited = new boolean[100000 + 1];
    currentPos.add(new CurrentPos(N, 0));
    // 시작위치를 방문한 것으로 처리
    visited[N] = true;
    // 큐가 빌 동안 bfs를 실시한다.
    end:
    while (!currentPos.isEmpty()) {
      CurrentPos pos = currentPos.pop();
      // 기본적으로 방문한 위치를 재방문하지 않도록 필터링
      // 현재위치값 * 2가 최대로 움직일 수 있는 위치값보다 크지 않을 경우 현재 위치 * 2만큼 이동
      if (pos.pos * 2 <= 100000 && !visited[pos.pos * 2]) {
        currentPos.add(new CurrentPos(pos.pos * 2, pos.spendTime + 1));
        visited[pos.pos * 2] = true;
        if (pos.pos * 2 == K) {
          System.out.println(pos.spendTime + 1);
          break end;
        }
      }
      if (pos.pos + 1 <= 100000 && !visited[pos.pos + 1]) {
        // 현재위치값 + 1가 최대로 움직일 수 있는 위치값보다 크지 않을 경우 현재 위치 + 1 만큼 이동
        currentPos.add(new CurrentPos(pos.pos + 1, pos.spendTime + 1));
        visited[pos.pos + 1] = true;
        if (pos.pos + 1 == K) {
          System.out.println(pos.spendTime + 1);
          break end;
        }
      }

      if (pos.pos - 1 >= 0 && !visited[pos.pos - 1]) {
        // 현재위치값 - 1이 0보다 크거나 같을 경우 현재 위치 -1로 이동
        currentPos.add(new CurrentPos(pos.pos - 1, pos.spendTime + 1));
        visited[pos.pos - 1] = true;
        if (pos.pos - 1 == K) {
          System.out.println(pos.spendTime + 1);
          break end;
        }
      }
    }

  }

  public static class CurrentPos {

    int pos;
    int spendTime;

    public CurrentPos(int pos, int spendTime) {
      this.pos = pos;
      this.spendTime = spendTime;
    }
  }


}