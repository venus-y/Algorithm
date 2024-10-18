import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int K;

    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> memberNumbers = new LinkedList<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            memberNumbers.add(i);
        }

        while (!memberNumbers.isEmpty()) {
            if (count % K == 0) {
                answerList.add(memberNumbers.poll());
                count++;
                continue;
            }
            count++;
            Integer poll = memberNumbers.poll();
            memberNumbers.add(poll);


        }

        System.out.print("<");
        for (int i = 0; i < answerList.size(); i++) {
            if (i == answerList.size() - 1) {
                System.out.print(answerList.get(i));
                break;
            }
            System.out.print(answerList.get(i) + ", ");

        }
        System.out.print(">");

    }

}
















