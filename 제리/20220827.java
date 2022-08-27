import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public int solution(int[] queue1, int[] queue2) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		long sum1 = 0;
		long sum2 = 0;

		for (int value : queue1) {
			q1.offer(value);
			sum1 += value;
		}

		for (int value : queue2) {
			q2.offer(value);
			sum2 += value;
		}

		int answer = 0;
		while (sum1 != sum2) {
			if (answer >= (queue1.length + 1) * 2) {
				answer = -1;
				break;
			}
			if (sum1 > sum2) {
				int value = q1.poll();
				q2.offer(value);
				sum1 -= value;
				sum2 += value;
			} else {
				int value = q2.poll();
				q1.offer(value);
				sum2 -= value;
				sum1 += value;
			}
			answer++;
		}

		return answer;
	}
}
