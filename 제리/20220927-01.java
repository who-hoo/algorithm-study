class Solution {

	public int solution(int[][] triangle) {
		int length = triangle.length;
		int[][] dp = new int[length][length];
		dp[0][0] = triangle[0][0];

		for (int i = 1; i < length; i++) {
			dp[i][0] = triangle[i][0] + dp[i - 1][0];

			for (int j = 1; j <= i; j++) {
				dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
			}
		}

		int answer = 0;
		for (int i = 0; i < dp[length - 1].length; i++) {
			answer = Math.max(dp[length - 1][i], answer);
		}
		return answer;
	}
}
