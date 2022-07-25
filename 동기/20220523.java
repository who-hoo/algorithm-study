import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited;
	static int N;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (max < graph[i][j]) {
					max = graph[i][j];
				}
			}
		}

		int result = 0;
		for (int height = 0; height < max; height++) {
			visited = new boolean[N][N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && graph[i][j] > height) {
						count += dfs(i, j, height);
					}
				}
			}
			result = Math.max(count, result);
		}
		System.out.println(result);
	}

	private static int dfs(int i, int j, int height) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
			if (visited[nx][ny]) continue;
			if (graph[nx][ny] > height) {
				dfs(nx, ny, height);
			}
		}
		return 1;
	}

}
