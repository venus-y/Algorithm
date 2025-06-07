import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static StringTokenizer st;
  public static int N;
  public static int[] timeTable;
  public static int[] records;
  public static int sum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    // 인원별 소요시간을 기록하는 테이블
    timeTable = new int[N];
    for (int i = 0; i < timeTable.length; i++) {
      timeTable[i] = Integer.parseInt(st.nextToken());
    }
    // 시간을 오름차순 정렬
    Arrays.sort(timeTable);
    // 사용자별 소요 시간 기록 레코더
    records = new int[N];
    // 시간이 적게 걸리는 사람 순서대로 인출한 기록의 총합을 구한다.
    for (int i = 0; i < timeTable.length; i++) {
      if (i == 0) {
        records[i] = timeTable[i];
        sum += records[i];
        continue;
      }
      records[i] = records[i - 1] + timeTable[i];
      sum += records[i];
    }

    System.out.println(sum);

  }


}

