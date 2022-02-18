import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 3 <= N <= 5000
        int INF = 999_999_999;
        int[] dp = new int[5001]; //new int[N + 1]는 N이 3~5인 경우 for문에서 OutofBounds에러 남.

        for (int i = 0; i <= N; i++) {
            dp[i] = INF;
        }
        dp[3] = 1;
        dp[5] = 1;
        
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
