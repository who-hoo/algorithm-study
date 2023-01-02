class Solution {

    final int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] sum = new int[m][n][3]; // 0일 경우 : 0, 2일 경우 오른쪽 : 1, 2일 경우 아래 : 2
        for (int i = 1; i < n; i++) {
            if (cityMap[0][i] != 1) {
                sum[0][i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            if (cityMap[i][0] != 1) {
                sum[i][0][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 0) {
                    if (cityMap[i - 1][j] == 0) {
                        sum[i][j][0] = (sum[i][j][0] + sum[i - 1][j][0]) % MOD;
                    } else if (cityMap[i - 1][j] == 2) {
                        sum[i][j][0] = (sum[i][j][0] + sum[i - 1][j][2]) % MOD;
                    }

                    if (cityMap[i][j - 1] == 0) {
                        sum[i][j][0] = (sum[i][j][0] + sum[i][j - 1][0]) % MOD;
                    } else if (cityMap[i][j - 1] == 2) {
                        sum[i][j][0] = (sum[i][j][0] + sum[i][j - 1][1]) % MOD;
                    }
                } else if (cityMap[i][j] == 2) {
                    if (cityMap[i - 1][j] == 0) {
                        sum[i][j][2] = (sum[i][j][2] + sum[i - 1][j][0]) % MOD;
                    } else if (cityMap[i - 1][j] == 2) {
                        sum[i][j][2] = (sum[i][j][2] + sum[i - 1][j][2]) % MOD;
                    }

                    if (cityMap[i][j - 1] == 0) {
                        sum[i][j][1] = (sum[i][j][1] + sum[i][j - 1][0]) % MOD;
                    } else if (cityMap[i][j - 1] == 2) {
                        sum[i][j][1] = (sum[i][j][1] + sum[i][j - 1][1]) % MOD;
                    }
                }
            }
        }

        return sum[m - 1][n - 1][0];
    }
}
