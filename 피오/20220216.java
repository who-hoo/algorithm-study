
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N + 1];
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = arr[0];
        dp[1] = arr[1];
        if (N >= 2) {
            dp[2] = arr[1] + arr[2];            
        }
        

        
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max((arr[i - 1] + dp[i - 3]), dp[i - 2]) + arr[i];
        }
        
        System.out.println(dp[N]);

    }
}
