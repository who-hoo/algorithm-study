package 아더;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PRO_12978_배달 {

    public static void main(String[] args) {
        PRO_12978_배달 pro = new PRO_12978_배달();

        int N1 = 5;
        int[][] road1 = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K1 = 3;
        int N2 = 6;
        int[][] road2 = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int K2 = 4;

        System.out.println(pro.solution(N1, road1, K1));
        System.out.println(pro.solution(N2, road2, K2));
    }

    class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<List<Node>> nodelists = new ArrayList<>();
        int[] dist = new int[N + 1];

        Arrays.fill(dist, 999_999);

        for (int i = 0; i <= N; i++) {
            nodelists.add(new ArrayList<>());
        }

        for (int[] ints : road) {
            nodelists.get(ints[0]).add(new Node(ints[1], ints[2]));
            nodelists.get(ints[1]).add(new Node(ints[0], ints[2]));
        }

        // 1번 마을에서 배달 출발
        dist[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            // 갱신 불가능하면 패쓰!
            if (dist[currentNode.vertex] < currentNode.weight) {
                continue;
            }

            for (int i = 0; i < nodelists.get(currentNode.vertex).size(); i++) {
                Node node = nodelists.get(currentNode.vertex).get(i);

                int newWeight = currentNode.weight + node.weight;
                if (dist[node.vertex] > newWeight) {
                    dist[node.vertex] = newWeight;
                    pq.add(new Node(node.vertex, newWeight));
                }

            }
        }

        answer = (int) Arrays.stream(dist)
            .filter(distance -> distance <= K)
            .count();

        return answer;
    }
}
