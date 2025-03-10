import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int first;
    static int second;
    static int third;
    static int maxValue = Integer.MIN_VALUE;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while (true) {
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, first);
            second = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, second);
            third = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, third);
            if (first == 0 && second== 0 && third ==0) {
                break;
            }
            if (Math.pow(first, 2) + Math.pow(second, 2) + Math.pow(third, 2) - Math.pow(maxValue,2)== Math.pow(maxValue, 2)) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
            maxValue = Integer.MIN_VALUE;
        }

        System.out.println(sb.toString());



    }
}