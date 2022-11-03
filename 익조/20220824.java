import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int[] queue1, int[] queue2) {
        int length = queue1.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        long sum1 = getSum(q1), sum2 = getSum(q2);
        int result, count = 0;
        while (true) {
            if (count > 2 * length + 2) {
                return -1;
            } else if (sum1 > sum2) {
                Integer i1 = q1.poll();
                q2.add(i1);
                sum1 -= i1;
                sum2 += i1;
                count++;
            } else if (sum1 < sum2) {
                Integer i2 = q2.poll();
                q1.add(i2);
                sum1 += i2;
                sum2 -= i2;
                count++;
            } else {
                result = count;
                break;
            }
        }

        return result;
    }

    private long getSum(Queue<Integer> queue) {
        long sum = 0;
        for (Integer i : queue) {
            sum += i;
        }

        return sum;
    }
}
