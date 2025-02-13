import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Main main = new Main();
        System.out.println(main.solution(n));


    }

    public int solution(int n) {

            int startValue = 666;
            int matchedCount = 0;
        while (true){
            if (String.valueOf(startValue).contains("666")) {
                matchedCount++;
            }
            if (matchedCount == n) {
                return startValue;
            }
            startValue++;
        }
    }
}
