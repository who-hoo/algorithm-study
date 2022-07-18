package programmers.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7,4,5,6})); // answer: 8
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> trucksOnTheBridge = new LinkedList<>();
        trucksOnTheBridge.add(truck_weights[0]);
        answer += bridge_length;
        int truckWeightSum = truck_weights[0];
        int i = 1;
        while (i <= truck_weights.length - 1) {
            int nextTruck = truck_weights[i];
            int expectedWeight = truckWeightSum + nextTruck;
            if (weight < expectedWeight) {
            }

        }

        return answer;
    }
}
