import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[city + 1];
        List<List<Bus>> lines = new ArrayList<>();


        for (int i = 0; i <= city; i++) {
            lines.add(new ArrayList<>());
        }

        for (int i = 0; i < bus; i++) {
            String[] s = br.readLine().split(" ");

            int start = Integer.parseInt(s[0]);
            int destination = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            lines.get(start).add(new Bus(destination, cost));
        }

        int[] costList = new int[city + 1];
        Arrays.fill(costList, Integer.MAX_VALUE);

        PriorityQueue<Bus> q = new PriorityQueue<>();

        String[] travel = br.readLine().split(" ");
        int startIndex = Integer.parseInt(travel[0]);
        int destinationIndex = Integer.parseInt(travel[1]);

        costList[startIndex] = 0;
        q.offer(new Bus(startIndex, 0));

        while (!q.isEmpty()) {
            Bus currentBus = q.poll();

            if (!visited[currentBus.destination]) {
                visited[currentBus.destination] = true;
                List<Bus> buses = lines.get(currentBus.destination);

                for (Bus b : buses) {
                    if (!visited[b.destination] && b.cost + costList[currentBus.destination] < costList[b.destination]) {
                        costList[b.destination] = costList[currentBus.destination] + b.cost;
                        q.offer(new Bus(b.destination, costList[b.destination]));
                    }
                }
            }
        }
        System.out.println(costList[destinationIndex]);
    }

    static class Bus implements Comparable<Bus>{
        private int destination;
        private int cost;

        public Bus(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return cost - o.cost;
        }
    }

}
