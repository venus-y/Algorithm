import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int answer;
    static int count;

    static boolean check = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        Queue<PriorityQueue> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            answer = M;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                queue.add(new PriorityQueue(j, Integer.parseInt(st.nextToken())));
            }

            while (!queue.isEmpty()) {
                PriorityQueue peek = queue.peek();
                for (PriorityQueue p : queue) {
                    if (p.priority > peek.priority) {
                        queue.add(queue.poll());
                        check = false;
                        break;
                    }
                }
                if (check == true) {
                    PriorityQueue poll = queue.poll();
                    count++;
                    if (poll.no == answer) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
                check = true;
            }
            queue.clear();
            count = 0;
        }
        System.out.println(sb.toString());
    }
}

class PriorityQueue {
    int no;
    int priority;

    public PriorityQueue(int no, int priority) {
        this.no = no;
        this.priority = priority;
    }
}
