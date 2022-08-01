import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Bus implements Comparable<Bus> {

        int index;
        int cost;

        Bus(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(in.readLine()); // 도시의 개수
        final int M = Integer.parseInt(in.readLine()); // 버스의 개수

        ArrayList<ArrayList<Bus>> graph = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] costs = new int[N+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Bus(to, cost));
        }

        StringTokenizer st = new StringTokenizer(in.readLine());
        final int FROM = Integer.parseInt(st.nextToken());
        final int TO = Integer.parseInt(st.nextToken());

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(FROM, 0));
        costs[FROM] = 0;
        while (!pq.isEmpty()) {
            Bus currentBus = pq.poll();
            if (costs[currentBus.index] < currentBus.cost) {
                continue;
            }
            for (Bus bus : graph.get(currentBus.index)) {
                int cost = costs[currentBus.index] + bus.cost;
                if (cost < costs[bus.index]) {
                    costs[bus.index] = cost;
                    pq.offer(new Bus(bus.index, bus.cost));
                }
            }
        }
        out.write(String.valueOf(costs[TO]));

        out.close();
        in.close();
    }
}
