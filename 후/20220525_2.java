import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static int[] dRow = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dCol = {0, 0, -1, 1}; // 상 하 좌 우
	static int R;
	static int C;
	static char[][] board;
	static Set<Character> passable;

	static int dfs(int row, int col, int count) {
		int result = count;
		if (row < 0 || row > R - 1 || col < 0 || col > C - 1) {
			return result;
		}
		if (passable.add(board[row][col])) {
			for (int d  = 0; d < 4; d++) {
				result = dfs(row + dRow[d], col + dCol[d], count+1);
			}
			return result;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		board = new char[R][C];
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				board[row][col] = (char) br.read();
			}
			br.read();
		}
		br.close();

		int answer = 0;
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				passable = new HashSet<>();
				int count = dfs(row, col, 0);
				if (dfs(row, col, 0) != -1) {
					answer = Math.max(answer, count);
				}
			}
		}

		System.out.println(answer);
	}
}
