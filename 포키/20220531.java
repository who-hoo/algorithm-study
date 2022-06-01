package level2;

import java.util.*;

public class 20220531 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> time = new LinkedList<>();
        Queue<Integer> passed = new LinkedList<>();
        Queue<Integer> passing = new LinkedList<>();

        int index = 0;

        while (passed.size() != truck_weights.length) {
            answer ++;
            if (!passing.isEmpty()) {
                if (time.peek() + bridge_length == answer) {
                    int poll = passing.poll();
                    passed.add(poll);
                    sum -= poll;
                    time.poll();
                }

            }
            if (index < truck_weights.length) {
                if (sum + truck_weights[index] <= weight) {
                    sum += truck_weights[index];
                    time.add(answer);
                    passing.add(truck_weights[index]);
                    index++;
                }
            }

        }

        return answer;
    }
}
