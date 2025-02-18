import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Priority> priorityQueue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            Priority priority = new Priority(i, priorities[i]);
            priorityQueue.add(priority);
        }

        while (true) {
            boolean max = true;
            Priority poll = priorityQueue.poll();
            for (Priority compare : priorityQueue) {
                if (compare.priority > poll.priority) {
                    max = false;
                    priorityQueue.add(poll);
                    break;
                }
            }
            if (max) {
                answer++;
                if (poll.location == location) {
                    return answer;
                }
            }
        }

    }
}
    
    class Priority {
    int location;
    int priority;

    public Priority(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }
}
    
