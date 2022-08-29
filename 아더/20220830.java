package 아더;

import java.util.LinkedList;
import java.util.Queue;

public class PRO_118667_두큐합같게만들기 {

    public static void main(String[] args) {
        PRO_118667_두큐합같게만들기 pro = new PRO_118667_두큐합같게만들기();

        int[] queue11 = {3, 2, 7, 2};
        int[] queue12 = {4, 6, 5, 1};

        int[] queue21 = {1, 2, 1, 2};
        int[] queue22 = {1, 10, 1, 2};

        int[] queue31 = {1, 1};
        int[] queue32 = {1, 5};

        System.out.println(pro.solution(queue11, queue12));
        System.out.println(pro.solution(queue21, queue22));
        System.out.println(pro.solution(queue31, queue32));
    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int length = queue1.length;

        Queue<Integer> que1 = new LinkedList<>();
        long sum1 = 0;
        Queue<Integer> que2 = new LinkedList<>();
        long sum2 = 0;
        for (int i = 0; i < length; i++) {
            que1.add(queue1[i]);
            sum1 += queue1[i];
            que2.add(queue2[i]);
            sum2 += queue2[i];
        }

        while (true) {
            if (answer > length * 2 + 2) {
                answer = -1;
                break;
            }

            if (sum1 == sum2) {
                break;
            }

            if (sum1 > sum2) {
                Integer num = que1.poll();
                que2.add(num);
                sum1 -= num;
                sum2 += num;
            } else {
                Integer num = que2.poll();
                que1.add(num);
                sum2 -= num;
                sum1 += num;
            }
            answer++;
        }

        return answer;
    }
}
