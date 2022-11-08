import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    static final int INF = (int) 2e9;
    static ArrayList<ArrayList<Node>> towns = new ArrayList<>();
    static int[] times;

    static class Node implements Comparable<Node> {

        private final int index;
        private final int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return this.index;
        }

        public int getTime() {
            return this.time;
        }

        @Override
        public int compareTo(Node other) {
            if (this.time < other.time) {
                return -1;
            }
            return 1;
        }
    }

    public int solution(int N, int[][] road, int K) {
        times = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            towns.add(new ArrayList<>());
        }

        for (int[] r : road) {
            towns.get(r[0]).add(new Node(r[1], r[2]));
            towns.get(r[1]).add(new Node(r[0], r[2]));
        }

        Arrays.fill(times, INF);

        delivery(1);

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (times[i] <= K) {
                result++;
            }
        }

        return result;
    }

    private void delivery(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        times[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int time = node.getTime();
            int now = node.getIndex();

            if (times[now] < time) continue;

            for (int i = 0; i < towns.get(now).size(); i++) {
                int cost = times[now] + towns.get(now).get(i).getTime();
                if (cost < times[towns.get(now).get(i).getIndex()]) {
                    times[towns.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(towns.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}
