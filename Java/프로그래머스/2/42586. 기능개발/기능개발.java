import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Progress> deque = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            deque.add(new Progress(progresses[i], speeds[i]));
        }
        while (!deque.isEmpty()) {
            int count = 0;

            while (deque.peek().progress < 100) {

                for (Progress progress : deque) {
                    progress.progress += progress.speed;
                }


            }
//            for (Progress progress : deque) {
//                if (progress.progress >= 100) {
//                    deque.poll();
//                    count++;
//                } else {
//                    break;
//                }
//            }
//            answer.add(count);
            while (!deque.isEmpty() && deque.peek().progress >= 100) {
                deque.poll();
                count++;
            }
            answer.add(count);

        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Progress {
    int progress;
    int speed;

    public Progress(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}