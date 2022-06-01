import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Truck {

        int weight;
        int movingTime;

        public Truck(int weight, int movingTime) {
            this.weight = weight;
            this.movingTime = movingTime;
        }

        public void plus() {
            movingTime++;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitingTrucks = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            waitingTrucks.add(truckWeight);
        }

        int time = 1, presentWeight = waitingTrucks.poll(), presentCountOfTrucks = 1;

        Queue<Truck> passingTrucks = new LinkedList<>();
        Truck truck = new Truck(presentWeight, 0);
        passingTrucks.add(truck);

        while (!waitingTrucks.isEmpty()) {
            passingTrucks.forEach(Truck::plus);

            if (passingTrucks.peek().movingTime == bridge_length) {
                presentWeight -= passingTrucks.poll().weight;
                presentCountOfTrucks--;
            }

            time++;

            if (presentWeight + waitingTrucks.peek() <= weight
                && presentCountOfTrucks <= bridge_length) {

                int w = waitingTrucks.poll();
                passingTrucks.add(new Truck(w, 0));
                presentWeight += w;
                presentCountOfTrucks++;
            }
        }

        return time + bridge_length;
    }
}
