import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input1 = br.readLine().toCharArray();
		char[] input2 = br.readLine().toCharArray();

		int[][] dp = new int[input2.length + 1][input1.length + 1];

		for (int i = 1; i <= input2.length; i++) {
			for (int j = 1; j <= input1.length; j++) {
				if (input1[j - 1] == input2[i - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[input2.length][input1.length]);

	}
}
