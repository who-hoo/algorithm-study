package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static int N, M, START, END;
    static int[] dist;
    static List<Edge>[] edges;

    static class Info {
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(dist[END]);
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.add(new Info(START, 0));
        dist[START] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (dist[info.idx] < info.dist) {
                continue;
            }

            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[info.idx] + e.weight;
                    pq.add(new Info(e.to, dist[e.to]));
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            edges[Integer.parseInt(split[0])].add(
                new Edge(
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[2])
                )
            );
        }

        String[] split = br.readLine().split(" ");
        START = Integer.parseInt(split[0]);
        END = Integer.parseInt(split[1]);
    }
}
