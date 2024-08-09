import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String input = st.nextToken();
            if (input.equals("push")) {
                int pushValue = Integer.parseInt(st.nextToken());
                queue.add(pushValue);
            } else if (input.equals("front")) {
                if (!queue.isEmpty()) {
                    Integer peek = queue.peek();
                    if (i == N - 1) {
                        sb.append(peek);
                    } else {
                        sb.append(peek).append("\n");
                    }
                } else {
                    if (i == N - 1) {
                        sb.append(-1);
                    } else {
                        sb.append(-1).append("\n");
                    }
                }
            } else if (input.equals("back")) {
                if (!queue.isEmpty()) {
                    Integer last = queue.peekLast();
                    if (i == N - 1) {
                        sb.append(last);
                    } else {
                        sb.append(last).append("\n");
                    }
                } else {
                    if (i == N - 1) {
                        sb.append(-1);
                    } else {
                        sb.append(-1).append("\n");
                    }
                }

            } else if (input.equals("empty")) {
                if (i == N - 1) {
                    sb.append(queue.isEmpty() ? 1 : 0);
                } else {
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                }
            } else if (input.equals("size")) {
                if (i == N - 1) {
                    sb.append(queue.size());
                } else {
                    sb.append(queue.size()).append("\n");
                }
            } else if (input.equals("pop")) {
                if (!queue.isEmpty()) {
                    if (i == N - 1) {
                        sb.append(queue.pop());
                    } else {
                        sb.append(queue.pop()).append("\n");
                    }
                } else {
                    if (i == N - 1) {
                        sb.append(-1);
                    } else {
                        sb.append(-1).append("\n");
                    }
                }
            }
        }
//        String result = sb.toString();
//
//        String[] split = result.split("\n");
//        for (int i = 0; i < split.length; i++) {
//            if (i == split.length - 1) {
//                System.out.print(split[i]);
//            } else {
//                System.out.println(split[i]);
//            }
//        }

        System.out.print(sb.toString());


    }
}
