class Solution {

    int MOD = 20170805;

    public int solution (int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        if (cityMap[1][0] != 1) {
            dp[1][0] = 1;
        } else {
            dp[1][0] = 0;
        }

        if (cityMap[0][1] != 1) {
            dp[0][1] = 1;
        } else {
            dp[0][1] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i - 1][j] == 1) {
                    continue;
                }

                if (cityMap[i][j - 1] == 1) {
                    continue;
                }

                if (cityMap[i][j] == 2) {
                    dp[i][j] += (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                }

                if (cityMap[i][j] == 0) {
                    dp[i][j] += (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                }
            }
        }

        return dp[m - 1][n - 1] % MOD;
    }
}
