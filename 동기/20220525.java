import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;
	static boolean[] alphabet = new boolean[26];
	static String[][] board;
	static int R;
	static int C;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Scanner sc = new Scanner(System.in);

		R = Integer.parseInt(st.nextToken());	// 세로 R칸
		C = Integer.parseInt(st.nextToken());	// 가로 C칸

		board = new String[R + 1][C + 1];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().split("");
		}

		// 말은 상하좌우 인접한 네 칸 중 한 칸으로 이동
		// 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과 달라야함
		// 같은 알파벳이 적힌 칸을 두 번 지날 수 없음
		// String 이 아닌 Character 로 저장하면될듯

		visited = new boolean[R + 1][C + 1];
		result = 0;
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				dfs(i, j);
//			}
//		}
		dfs(0, 0, 0);

		System.out.println(result);

}

	private static void dfs(int x, int y, int count) {
		if (visited[x][y]) {
			result = Math.max(result, count);
			return;
		}

		visited[x][y] = true;
		char c = board[x][y].charAt(0);
		alphabet[c - 65] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx > R - 1 || ny > C - 1) continue;
			if (visited[nx][ny]) continue;
			// 방문하지 않은 알파벳이면 dfs 실행
//			if (!alphabet[board[nx][ny].charAt(0) - 65]) {
//				dfs(nx, ny, count + 1);
//			}
			dfs(nx, ny, count + 1);
		}
		visited[x][y] = false;
	}

}
