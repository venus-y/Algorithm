import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashSet<Integer> numbers = new HashSet<>();
    static StringTokenizer st;
    static int matchedCount = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                numbers.add(Integer.parseInt(br.readLine()));
            }
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(br.readLine());
                if (numbers.contains(num)) {
                    matchedCount++;
                }
            }
            System.out.println(matchedCount);
            matchedCount = 0;
            numbers.clear();
        }

    }
}