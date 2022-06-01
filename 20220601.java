import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    static class Truck {
        int weight;
        int position;

        public Truck(int weight, int position) {
            this.weight = weight;
            this.position = position;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;

        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int w : truck_weights) {
            waitQ.add(new Truck(w, 0));
        }

        int w = 0;
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {

            // 1. 큐 안의 거리 갱신
            if(!moveQ.isEmpty()) {
                for (Truck truck : moveQ) {
                    truck.position++;
                }
                for (Truck truck : moveQ) {
                    if(truck.position == bridge_length) {
                        moveQ.poll();
                        w -= truck.weight;
                        break;
                    }
                }
            }

            // 2. 가능하다면 큐에 넣기
            if(!waitQ.isEmpty()) {
                Truck pk = waitQ.peek();
                if (w + pk.weight <= weight) {
                    w += pk.weight;
                    moveQ.add(waitQ.poll());
                }
            }

            // 3. 시간 변화시키기
            answer++;
        }

        return answer - 1;
    }
}
