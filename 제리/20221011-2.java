import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int map[][];
	private static int[] count = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, n);

		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
	}

	private static void divide(int row, int col, int size) {
		if (check(row, col, size)) {
			count[map[row][col] + 1]++;
			return;
		}
		int newSize = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				divide(row + newSize * i, col + newSize * j, newSize);
			}
		}
	}

	private static boolean check(int row, int col, int size) {
		int color = map[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (color != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
