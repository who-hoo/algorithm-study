import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static final int INF = (int) 1e9;
    public static ArrayList<ArrayList<Node>> cities = new ArrayList<>();
    public static int[] costs;

    static class Node implements Comparable<Node> {

        private final int index;
        private final int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return this.index;
        }

        public int getDistance() {
            return this.distance;
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());

        costs = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            cities.add(new ArrayList<>());
        }

        StringTokenizer st;
        int x, y, cost;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            cities.get(x).add(new Node(y, cost));
        }

        Arrays.fill(costs, INF);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(costs[end]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        costs[start] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if (costs[now] < dist) continue;

            for (int i = 0; i < cities.get(now).size(); i++) {
                int cost = costs[now] + cities.get(now).get(i).getDistance();
                if (cost < costs[cities.get(now).get(i).getIndex()]) {
                    costs[cities.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(cities.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}
