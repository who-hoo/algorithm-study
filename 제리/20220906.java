import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

	static class Town implements Comparable<Town> {

		int num;
		int time;

		public Town(int num, int time) {
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Town o) {
			return this.time - o.time;
		}
	}

	List<List<Town>> map;
	int[] answer;

	public int solution(int N, int[][] road, int K) {

		map = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
		}

		answer = new int[N + 1];

		for (int[] info : road) {
			map.get(info[0]).add(new Town(info[1], info[2]));
			map.get(info[1]).add(new Town(info[0], info[2]));
		}

		dijkstra(N);

		int count = 0;
		for (int time : answer) {
			if (time <= K) {
				count++;
			}
		}

		return count;
	}

	private void dijkstra(int N) {
		Arrays.fill(answer, 987654321);
		PriorityQueue<Town> pq = new PriorityQueue<>();
		pq.offer(new Town(1, 0));
		answer[1] = 0;

		while (!pq.isEmpty()) {
			Town now = pq.poll();

			for (Town town : map.get(now.num)) {
				if (answer[town.num] > answer[now.num] + town.time) {
					answer[town.num] = answer[now.num] + town.time;
					pq.offer(new Town(town.num, answer[town.num]));
				}
			}
		}
	}
}
