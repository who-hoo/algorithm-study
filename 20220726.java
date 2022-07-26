package beakjoon.main_1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main_dijkstra {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //도시의 개수
        int m = Integer.parseInt(br.readLine()); //버스의 개수

        boolean[] visited = new boolean[n + 1];
        int[] d = new int[n + 1]; //최소 비용 테이블
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]);
            int departure = Integer.parseInt(edge[1]);
            int cost = Integer.parseInt(edge[2]);
            graph.get(start).add(new Node(departure, cost));
        }

        String[] targetSd = br.readLine().split(" ");
        int start = Integer.parseInt(targetSd[0]);
        int departure = Integer.parseInt(targetSd[1]);
        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            if (!visited[currentNode.idx]) {
                visited[currentNode.idx] = true;

                for (Node node : graph.get(currentNode.idx)) {
                    if (!visited[node.idx] && d[currentNode.idx] + node.cost < d[node.idx]) {
                        d[node.idx] = d[currentNode.idx] + node.cost;
                        pq.add(new Node(node.idx, d[node.idx]));
                    }
                }

            }
        }
        System.out.println(d[departure]);
    }

}

class Node implements Comparable<Node> {

    int idx; //도착지점
    int cost; //도착지점으로 가는 비용

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
