import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                answer.add(queue.poll());
            } else if (count % K == 0) {
                answer.add(queue.poll());
            } else {
                queue.add(queue.poll());
            }
            count++;
        }

        System.out.print("<");
        for (int i = 0; i < answer.size(); i++) {
            if (i == answer.size() - 1) {
                System.out.print(answer.get(i));
            } else {
                System.out.print(answer.get(i) + ", ");
            }
        }
        System.out.print(">");


    }
}
