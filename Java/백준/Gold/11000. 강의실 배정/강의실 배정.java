import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static StringTokenizer st;
  public static int N;
  public static int S;
  public static int T;
  public static int roomCount = 1;
  public static int endTime;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    List<Lecture> lectures = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      S = Integer.parseInt(st.nextToken());
      T = Integer.parseInt(st.nextToken());
      lectures.add(new Lecture(S, T));
    }
    lectures.sort(Comparator.comparing(Lecture::getStartTime));

    PriorityQueue<Lecture> lecturePriorityQueue = new PriorityQueue<>();
    lecturePriorityQueue.add(lectures.get(0));

    for (int i = 1; i < lectures.size(); i++) {
      if (lecturePriorityQueue.peek().endTime <= lectures.get(i).startTime) {
        lecturePriorityQueue.poll();
        lecturePriorityQueue.add(lectures.get(i));
      } else {
        lecturePriorityQueue.add(lectures.get(i));
      }
    }

    System.out.println(lecturePriorityQueue.size());


  }

  public static class Lecture implements Comparable<Lecture> {

    int startTime;
    int endTime;

    public Lecture(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public int getStartTime() {
      return this.startTime;
    }

    public int getEndTime() {
      return this.endTime;
    }

    @Override
    public int compareTo(Lecture o) {
      return this.endTime - o.endTime;
    }
  }
}

