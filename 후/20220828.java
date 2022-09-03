import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        int answer = -1;
        int count = 0;
        long sum1 = q1.stream().mapToLong(Integer::longValue).sum();
        long sum2 = q2.stream().mapToLong(Integer::longValue).sum();
        while (true) {
            if (count > queue1.length * 2 + 2) {
                break;
            }
            if (sum1 == sum2) {
                answer = count;
                break;
            } else if (sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.offer(q1.poll());
            } else if (sum1 < sum2){
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.offer(q2.poll());
            }
            count++;
        }

        return answer;
    }
}
