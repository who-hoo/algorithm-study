import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int stair[] = new int[301];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int[] dp = new int[301];
        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];

        for (int i = 3; i <= n ; i++) {
            int before1 = dp[i-3] + stair[i-1] + stair[i];
            int before2 = dp[i-2] + stair[i];
            int max = Math.max(before1, before2);
            dp[i] = max;
        }

        System.out.println(dp[n]);
    }
}
