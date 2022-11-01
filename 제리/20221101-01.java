import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	static int[] dx = new int[]{1, -1, 0, 0};
	static int[] dy = new int[]{0, 0, 1, -1};
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		while (true) {
			time++;
			visited = new boolean[n][m];
			markOutsideAir(0, 0);
			deleteCheese();
			if (end()) {
				break;
			}
		}

		System.out.println(time);
	}

	private static void markOutsideAir(int x, int y) {
		map[x][y] = 2;
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}

			if (!visited[nx][ny] && (map[nx][ny] == 0 || map[nx][ny] == 2)) {
				markOutsideAir(nx, ny);
			}
		}
	}

	private static void deleteCheese() {
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				if (map[i][j] == 1) {
					int count = 0;
					for (int k = 0; k < 4; k++) {
						int x = dx[k];
						int y = dy[k];
						if (map[i - x][j - y] == 2) {
							count++;
						}
					}
					if (count >= 2) {
						map[i][j] = 0;
					}
				}
			}
		}
	}

	private static boolean end() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
