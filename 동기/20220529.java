import java.util.LinkedList;

public class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		/*
		트럭이 다리를 모두 지난 시점의 경과 시간을 출력
		트럭이 다리를 건널 때
			- 트럭이 다리에 올라갈 수 있는 총 무게는 weight이하
			- 트럭은

		다 됐고 일단 입력된 트럭을 순서대로 다리 길이를 반영하여 건너게 해보자
		다리 길이가 3면, answer가 증가하면서 트럭 한 대가 다리에 오른다
		다시 answer가 증가하고 트럭 한 대가 다리에 오른다
		다시 answer가 증가하고 트럭 한 대가 다리에 오른다(이 시점에서 다리는 다 찼다)
		answer가 증가하고 제일 처음 오른 트럭 한 대는 다리를 다 건넜다, 다시 트럭이 다리에 오른다
		다리는 무게만 감지..하고 만약 무게가 over되면 트럭이 오르지 않고 answer는 증가한다.
		각 트럭이 다리를 다 건너면 다리 무게를 원복시켜줘야한다.
		 */
		int answer = 0;
		LinkedList<Integer> truckQ = new LinkedList<>();
		for (int i = 0; i < truck_weights.length; i++) {
			truckQ.offer(truck_weights[i]);
		}

		LinkedList<Integer> bridgeQ = new LinkedList<>();
		for (int i = 0; i < bridge_length; i++) {
			bridgeQ.offer(0);
		}

		while (!truckQ.isEmpty()) {
			answer++;
			Integer truckPoll = truckQ.poll();

			if (bridgeQ.getFirst() != 0) {
				weight += bridgeQ.getFirst();
			}

			if (weight - truckPoll >= 0) {
				weight -= truckPoll;

				bridgeQ.poll();
				bridgeQ.addLast(truckPoll);

			} else {
				truckQ.addFirst(truckPoll);
				bridgeQ.poll();
				bridgeQ.addLast(0);
			}
		}

		answer += bridge_length;

		return answer;
	}

	public static void main(String[] args) {
		/*
		bridge_length	weight	truck_weights						return
		2				10		[7,4,5,6]							8
		100				100		[10]								101
		100				100		[10,10,10,10,10,10,10,10,10,10]		110
		 */

		int[] truck_weights = {7, 4, 5, 6};
		int[] truck_weights2 = {10};
		Solution s = new Solution();
		System.out.println(s.solution(100, 100, truck_weights2));
	}
}
