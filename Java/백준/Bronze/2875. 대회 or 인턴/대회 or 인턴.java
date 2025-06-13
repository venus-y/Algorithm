import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static StringTokenizer st;
  public static int N;
  public static int M;
  public static int K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // 여학생으로 팀을 구성할 수 있는 경우를 구한다.
    int girl = N / 2;
    // 남학생으로 팀을 구성할 수 있는 경우를 구한다.
    int boy = M;
    // 더 큰 쪽에서 인턴멤버를 차감한다.
    // girl과 boy중 더 작은 쪽만큼 팀을 만들 수 있기 때문에 girl과 boy가 같아질 때까지 더 큰쪽의 인원을 차감한다.
    while (true) {
      // 인턴 차출로 필요한 인원이 0이 되면 종료
      if (K == 0) {
        break;
      }
      // 여자로 팀을 이룰 수 있는 경우, 남자로 팀을 이룰 수 있는 경우가 같아지면 종료
      if (girl == boy) {
        break;
      }
      if (girl > boy) {
        N--;
        K--;
        girl = N / 2;
      } else {
        M--;
        K--;
        boy = M;
      }
    }

    while (true) {
      if (K == 0) {
        break;
      }
      N--;
      K--;
      if (K == 0) {
        break;
      }
      N--;
      K--;
      if (K == 0) {
        break;
      }
      M--;
      K--;
      if (K == 0) {
        break;
      }
    }

    int result = Math.min(N / 2, M);
    System.out.println(result);

  }


}

