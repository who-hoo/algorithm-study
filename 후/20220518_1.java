import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = (int) 1e9;
    static int N; // 마을 수
    static int M; // 도로 수
    static int X; // 파티를 하는 마을
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        for (int from = 1; from <= N; from++) {
            for (int to = 1; to <= N; to++) {
                if (from == to) {
                    graph[from][to] = 0;
                } else {
                    graph[from][to] = INF;
                }
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from][to] = cost;
        }

        for (int node = 1; node <= N; node++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    graph[from][to] = Math.min(graph[from][to], graph[from][node] + graph[node][to]);
                }
            }
        }

        int maxCost = 0;
        int[] costs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int currentCost = graph[i][X] + graph[X][i];
            costs[i] = graph[i][X] + graph[X][i];
            maxCost = Math.max(maxCost, currentCost);
        }

        br.close();
        System.out.println(maxCost);
    }
}
