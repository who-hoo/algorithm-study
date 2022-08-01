package Programmers.다리를지나는트럭;

/*
	문제    : 프로그래머스 다리를 지나는 트럭
    유형    : 큐
	난이도   : EASY(level 2)
	시간    : 25m
	uri    : https://programmers.co.kr/learn/courses/30/lessons/42583
    날짜    : 22.05.26(o)
    refer  :
*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		int initalLength = bridge_length;

		int onBridgeWeight = 0;

		Queue<Integer> truckLine = new LinkedList<>();
		Queue<Integer> onBridgeTruck = new LinkedList<>();

		while (bridge_length-- > 0) {
			onBridgeTruck.offer(0);
		}

		for (int truckWeight : truck_weights) {
			truckLine.offer(truckWeight);
		}

		while (!truckLine.isEmpty()) {
			int truck = truckLine.peek();
			onBridgeWeight -= onBridgeTruck.poll();

			if (onBridgeWeight + truck <= weight) {
				onBridgeWeight += truckLine.poll();
				onBridgeTruck.offer(truck);
			} else {
				onBridgeTruck.offer(0);
			}

			time++;
		}

		time += initalLength;

		return time;
	}

}
