import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static int X;
  public static int N;
  public static StringTokenizer st;
  public static int[] records;
  public static int countPeriod;
  public static int maxVisitorCount;
  public static int currentVisitorCount;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    records = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      records[i] = Integer.parseInt(st.nextToken());
    }

    // 최대 방문자 횟수를 초기화한다
    for (int i = 1; i <= X; i++) {
      maxVisitorCount += records[i];
    }
    currentVisitorCount = maxVisitorCount;
    if (maxVisitorCount != 0) {
      countPeriod = 1;
    }

    int lPointer = 1;
    int rPointer = X + 1;

    // 레코드를 순회하며 최대 방문자 횟수를 구한다.
    for (int i = X; i < N; i++) {
      if (i == 1) {
        continue;
      }
      currentVisitorCount = currentVisitorCount - records[lPointer++] + records[rPointer++];
      if (maxVisitorCount == currentVisitorCount) {
        countPeriod++;
      }
      if (currentVisitorCount > maxVisitorCount) {
        maxVisitorCount = currentVisitorCount;
        countPeriod = 1;
      }
    }

    if (X == 1) {
      maxVisitorCount = Math.max(maxVisitorCount,
          currentVisitorCount - records[lPointer] + records[rPointer]);
    }

    if (maxVisitorCount == 0) {
      System.out.println("SAD");
      return;
    }

    System.out.println(maxVisitorCount);
    System.out.println(countPeriod);

  }


}

