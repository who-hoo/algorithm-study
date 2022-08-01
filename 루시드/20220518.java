import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static final int INF = 9999999;
    static List<List<Node>> list = new ArrayList<>();
    static int[] result;
    static int N;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int X = Integer.parseInt(input[2]);

        answer = new int[N + 1][];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        while (M-- > 0) {
            String[] subInput = br.readLine().split(" ");
            int start = Integer.parseInt(subInput[0]);
            int dest = Integer.parseInt(subInput[1]);
            int dist = Integer.parseInt(subInput[2]);
            list.get(start).add(new Node(dest, dist));
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            max = Integer.max(max, answer[X][i] + answer[i][X]);
        }
        System.out.println(max);
    }

    private static void dijkstra(int index) {
        // 최단거리 갱신될 노드를 담을 우선순위 큐 설정
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 초기화
        result = new int[N + 1];
        Arrays.fill(result, INF);
        result[index] = 0;

        pq.offer(new Node(index, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int destination = node.destination;
            int dist = node.dist;

            if (dist > result[destination]) {
                continue;
            }

            for (Node linkedNode : list.get(destination)) {
                if (dist + linkedNode.dist < result[linkedNode.destination]) {
                    result[linkedNode.destination] = dist + linkedNode.dist;
                    pq.offer(new Node(linkedNode.destination, result[linkedNode.destination]));
                }
            }
        }

        // 계산된 배열 복사해서 넣기
        answer[index] = result.clone();
    }

    static class Node implements Comparable<Node>{
        int destination;
        int dist;

        public Node(int destination, int dist) {
            this.destination = destination;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}
