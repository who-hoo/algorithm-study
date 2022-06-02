import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
		List<Integer> trucks = Arrays.stream(truck_weights).boxed().collect(Collectors.toList());
		Queue<Integer> waitingQueue = new LinkedList<>(trucks);
		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < bridge_length; i++) { // 다리의 길이만큼 0으로 채워줌(1초에 한칸씩 이동할 수 있도록)
			bridge.offer(0);
		}
		int answer = 0;
		while (true) { // 1초 싸이클
			answer++;
			bridge.poll();
			if (isAvailable(weight, bridge_length, waitingQueue, bridge)) {
				bridge.offer(Optional.ofNullable(waitingQueue.poll()).orElse(0));
			} else {
				bridge.offer(0);
			}

      // 대기 트럭이 없고, 다리에 올라가 있는 트럭이 하나도 없으면(0 제외 <- 0은 빈칸이기 때문에) 반복문 탈출
			if (waitingQueue.isEmpty() && bridge.stream().noneMatch(b -> b != 0)) {
				break;
			}
		}
		return answer;
	}

	private boolean isAvailable(int weight, int bridge_length,
		Queue<Integer> waitingQueue, Queue<Integer> bridge) {
    // 다음으로 다리에 오를 트럭의 무게 + 현재 다리에 올라가 있는 트럭의 무게가 다리가 견딜 수 있는 무게(weight) 이하이고,
    // 현재 다리에 올라가 있는 트럭의 수 + 1이 다리에 오를 수 있는 트럭의 최대 수(bridge_length)대 이하이면 대기 큐에 있는 다음 트럭이 오를 수 있다.
		int nextTruckWeight = Optional.ofNullable(waitingQueue.peek()).orElse(0);
		int currentBridgeWeight = bridge.stream().mapToInt(Integer::intValue).sum();
		return nextTruckWeight + currentBridgeWeight <= weight && bridge.size() <= bridge_length - 1;
	}
}
