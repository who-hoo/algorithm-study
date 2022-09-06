package programmers.배달;

import java.util.*;

public class Solution2 {

    public static boolean[] visited;
    public static int[] dist;
    public static Map<Integer, List<Node>> graph;
    public static Set<Integer> answer = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solution(
            5,
            new int[][]{
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1}
            },
            3
        ));
    }

    public static int solution(int n, int[][] road, int k) {
        graph = new HashMap<>();

        for (int i = 0; i < road.length; i++) {
            int startNode = road[i][0];
            int endNode = road[i][1];
            int cost = road[i][2];
            List<Node> nodes1 = graph.getOrDefault(startNode, new ArrayList<>());
            List<Node> nodes2 = graph.getOrDefault(endNode, new ArrayList<>());
            nodes1.add(new Node(endNode, cost));
            nodes2.add(new Node(startNode, cost));
            graph.put(startNode, nodes1);
            graph.put(endNode, nodes2);
        }

        visited = new boolean[51];
        dist = new int[51];
        Arrays.fill(dist, Integer.MAX_VALUE);

        bfs();
        int answer = 0;
        for (int i = 1; i <= 50; i++) {
            if (dist[i] <= k) answer++;
        }

        return answer;
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));

        while (!q.isEmpty()) {
            Node currNode = q.poll();

            int cost = currNode.cost;
            if (!visited[currNode.idx]) {
                visited[currNode.idx] = true;

                for (Node nextNode : graph.get(currNode.idx)) {

                    if (!visited[nextNode.idx] && dist[currNode.idx] + nextNode.cost < dist[nextNode.idx]) {
                        dist[nextNode.idx] = dist[currNode.idx] + nextNode.cost;
                        q.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                    }
                }
            }

        }
    }

}

