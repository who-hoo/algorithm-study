import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int n;
        int[][] arr;
        int[][] dp;

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n];
            dp = new int[2][n];

            String[] split = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[0][i] = Integer.parseInt(split[i]);
            }

            split = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[1][i] = Integer.parseInt(split[i]);
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            if (n > 1) {
                dp[0][1] = dp[1][0] + arr[0][1];
                dp[1][1] = dp[0][0] + arr[1][1];

                for (int i = 2; i < n; i++) {
                    dp[0][i] = Math.max(Math.max(dp[1][i - 1], dp[1][i - 2]), dp[0][i - 2]) + arr[0][i];
                    dp[1][i] = Math.max(Math.max(dp[0][i - 1], dp[0][i - 2]), dp[1][i - 2]) + arr[1][i];
                }
            }
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.println(sb);
    }
}
