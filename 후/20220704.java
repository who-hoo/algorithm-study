import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] stickers = new int[2][n + 1];
			int[][] memo = new int[2][n + 1];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			memo[0][1] = stickers[0][1];
			memo[1][1] = stickers[1][1];
			for (int i = 2; i <= n; i++) {
				memo[0][i] = (stickers[0][i] + Math.max(memo[1][i - 1], memo[1][i - 2]));
				memo[1][i] = (stickers[1][i] + Math.max(memo[0][i - 1], memo[0][i - 2]));
			}

			bw.write(Math.max(memo[0][n], memo[1][n]) + "\n");
		}

		bw.close();
		br.close();
	}
}
