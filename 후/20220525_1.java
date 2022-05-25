import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dRow = {1, -1, 0, 0}; // 상, 하, 좌, 우
	static int[] dCol = {0, 0, -1, 1}; // 상, 하, 좌, 우
	static int N;
	static boolean[][] visited;

	static boolean dfs(int row, int col) {
		if (row < 0 || row > N - 1 || col < 0 || col > N - 1) {
			return false;
		}
		if (!visited[row][col]) {
			visited[row][col] = true;
			for (int d = 0; d < 4; d++) {
				dfs(row + dRow[d], col + dCol[d]);
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;
		int max = 0;
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				int temp = Integer.parseInt(st.nextToken());
				map[row][col] = temp;
				max = Math.max(max, temp);
			}
		}
		br.close();

		int answer = 1; // 아무 지역도 물에 잠기지 않는다면 안전 지역의 개수는 0
		for (int h = 1; h <= max; h++) { // 내리는 비의 양에 따른 모든 경우를 조사
			visited = new boolean[N][N];

			// 비내리기
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (map[row][col] <= h) {
						visited[row][col] = true;
					}
				}
			}

			int count = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (dfs(row, col)) {
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
		}

		System.out.println(answer);
	}
}
