import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			int[][] map = new int[2][n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[0][j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[1][j] = Integer.parseInt(st.nextToken());
			}

			if (n == 1) {
				System.out.println(Math.max(map[0][0], map[1][0]));
				continue;
			}

			int[][] dp = new int[2][n];

			dp[0][0] = map[0][0];
			dp[1][0] = map[1][0];
			dp[0][1] = dp[1][0] + map[0][1];
			dp[1][1] = dp[0][0] + map[1][1];

			for (int j = 2; j < n; j++) {
				dp[0][j] = Math.max(Math.max(dp[0][j - 2] + map[0][j], dp[1][j - 2] + map[0][j]), dp[1][j - 1] + map[0][j]);
				dp[1][j] = Math.max(Math.max(dp[0][j - 2] + map[1][j], dp[1][j - 2] + map[1][j]), dp[0][j - 1] + map[1][j]);
			}
			System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
		}


	}

}
