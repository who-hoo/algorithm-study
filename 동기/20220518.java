import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());	// n명
		int m = Integer.parseInt(st.nextToken());	// m개의 도로 정보
		int x = Integer.parseInt(st.nextToken());	// 파티가 열릴 x번 마을
		int[][] graph = new int[n + 1][n + 1];
		int INF = 1_000_000;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				if (i == j) {
					graph[i][j] = 0;
				} else {
					graph[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from][to] = cost;
		}

		for (int k = 1; k <= n; k++) {	// 거쳐가는 노드
			for (int from = 1; from <= n; from++) {	// 출발
				for (int to = 1; to <= n; to++) {	// 도착
					graph[from][to] = Math.min(graph[from][to], graph[from][k] + graph[k][to]);
				}
			}
		}
		int maxCost = 0;
		for (int i = 1; i <= n; i++) {
			int currentCost = graph[i][x] + graph[x][i];
			maxCost = Math.max(currentCost, maxCost);
		}
		System.out.println(maxCost);
	}
}
