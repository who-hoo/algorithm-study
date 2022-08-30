import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];

            q2.add(queue2[i]);
            sum2 += queue2[i];
        }

        int count = 0;
        while (sum1 != sum2) {
            count++;

            if (sum1 < sum2) {
                Integer poll = q2.poll();
                sum1 += poll;
                sum2 -= poll;
                q1.offer(poll);
            } else {
                Integer poll = q1.poll();
                sum2 += poll;
                sum1 -= poll;
                q2.offer(poll);
            }

            if (count > (queue1.length + queue2.length) * 2) {
                return -1;
            }

        }
        return count;
    }
}
