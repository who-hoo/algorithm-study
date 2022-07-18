import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int answer = 987654321;
	static int[] dy = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dx = {0, 1, 0, -1}; // 상 우 하 좌
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int count = 0;

	static void search(int y, int x) {
		visited[y][x] = true;
		count++;
		if (y == N && x == M) {
			answer = Math.min(answer, count);
		}
		for (int i = 0; i < 4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if (1 <= nextY && nextY <= N && 1 <= nextX && nextX <= M
				&& !visited[nextY][nextX] && map[nextY][nextX] > 0) {
				search(nextY, nextX);
			}
		}
		visited[y][x] = false;
		count--;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		for (int n = 1; n <= N; n++) {
			String[] line = br.readLine().split("");
			for (int m = 1; m <= M; m++) {
				map[n][m] = Integer.parseInt(line[m-1]);
			}
		}
		br.close();

		search(1, 1);

		System.out.println(answer);
	}
}
