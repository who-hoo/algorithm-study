package AlgorithmStudy.boj2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];

        dp[0] = dp[1] = dp[2] = dp[4] = 9999;
        dp[3] = dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }
        if (dp[N] >= 9999) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}
