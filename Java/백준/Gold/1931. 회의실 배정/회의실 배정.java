import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static StringTokenizer st;
  public static int N;
  public static List<Conference> conferenceList = new ArrayList<>();
  public static int endTime;
  public static int conferenceCount = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int startTime = Integer.parseInt(st.nextToken());
      int endTime = Integer.parseInt(st.nextToken());
      conferenceList.add(new Conference(startTime, endTime));
    }

    // 시작시간 오름차순 정렬, 시작시간이 같다면 종료시간 오름차순 정렬
    conferenceList.sort(Comparator.comparing(Conference::getEndTime)
        .thenComparing(Conference::getStartTime));

    // 종료시간을 첫번째 회의의 종료 시간으로 초기화
    endTime = conferenceList.get(0).endTime;

    // 회의가 하나일 경우 1 반환
    if (N == 1) {
      System.out.println(1);
      return;
    }

    for (int i = 1; i < conferenceList.size(); i++) {
      if (conferenceList.get(i).startTime >= endTime) {
        endTime = conferenceList.get(i).endTime;
        conferenceCount++;
      }
    }

    System.out.println(conferenceCount);
  }

  public static class Conference {

    int startTime;
    int endTime;

    public Conference(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public int getStartTime() {
      return this.startTime;
    }

    public int getEndTime() {
      return this.endTime;
    }
  }


}

