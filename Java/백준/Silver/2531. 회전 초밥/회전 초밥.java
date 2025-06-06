import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static int N;
  public static int d;
  public static int k;
  public static int c;
  public static StringTokenizer st;
  public static int[] sushiNumbers;
  public static int[] counters;
  public static int maxCount;
  public static int curCount;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    // 접시 수
    N = Integer.parseInt(st.nextToken());
    // 초밥 종류 개수
    d = Integer.parseInt(st.nextToken());
    // 연속해서 먹어야 하는 접시의 수 = 윈도우 크기
    k = Integer.parseInt(st.nextToken());
    // 쿠폰으로 지급되는 초밥 번호
    c = Integer.parseInt(st.nextToken());

    // 스시를 먹은 횟수를 담는 카운터
    counters = new int[d + 1];
    // 스시 번호를 담는 배열
    sushiNumbers = new int[N];
    // 스시를 담을 큐
    Deque<Sushi> sushis = new ArrayDeque<>();
    // 스시 종류를 최대로 많이 먹은 횟수를 초기화
    maxCount = Integer.MIN_VALUE;

    for (int i = 0; i < N; i++) {
      int sushiNum = Integer.parseInt(br.readLine());
      sushiNumbers[i] = sushiNum;
    }

    // 연속해서 먹어야 하는 갯수만큼 스시를 담는다.
    for (int i = 0; i < k; i++) {
      int sushiNum = sushiNumbers[i];
      counters[sushiNum] += 1;
      sushis.add(new Sushi(sushiNum));
      if (counters[sushiNum] == 1) {
        curCount++;
      }
    }
    if (counters[c] == 0) {
      curCount++;
    }
    maxCount = Math.max(curCount, maxCount);
    // 쿠폰으로 받은 스시가 있었다면 스시 종류 카운트 감소
    if (counters[c] == 0) {
      curCount--;
    }

    for (int i = 1; i < N; i++) {
      // 제일 앞에 있던 초밥을 빼고 카운트 감소
      Sushi firstSushi = sushis.pollFirst();
      counters[firstSushi.num] -= 1;
      if (counters[firstSushi.num] == 0) {
        --curCount;
      }
      // 새로 추가한 초밥을 추가하고 카운트 증가
      int sushiNum = sushiNumbers[(i + k - 1) % N];
      counters[sushiNum] += 1;
      sushis.add(new Sushi(sushiNum));
      if (counters[sushiNum] == 1) {
        curCount++;
      }
      if (counters[c] == 0) {
        curCount++;
      }
      maxCount = Math.max(curCount, maxCount);
      // 쿠폰으로 증정받은 초밥의 갯수를 감소
      if (counters[c] == 0) {
        curCount--;
      }
    }

    System.out.println(maxCount);

  }


  public static class Sushi {

    int num;

    public Sushi(int num) {
      this.num = num;
    }
  }


}

