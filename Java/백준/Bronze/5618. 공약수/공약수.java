import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, numbers[i]);
        }
        int GCD = min;
        while(true) {
            boolean check = true;
            for(int i = 0; i < numbers.length; i++) {
                if(numbers[i] % GCD != 0) {
                    check = false;
                }
            }
            if(check) {
                break;
            }
            GCD--;
        }
        for(int i = 1; i <= GCD; i++) {
            if(GCD % i == 0) {
                System.out.println(i);
            }
        }
    }
}