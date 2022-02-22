import java.util.Scanner;

public class BOJ1149{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int houseCount = sc.nextInt();
        int[][] colors = new int[houseCount + 1][4];
        int[][] dp = new int[houseCount + 1][4];

        for (int i = 1; i <= houseCount; i++) {
            for (int j = 1; j < 4; j++) {
                colors[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < 4; i++) {
            dp[1][i] = colors[1][i];
        }

        for (int i = 2; i <= houseCount; i++) {
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][3]) + colors[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][3]) + colors[i][2];
            dp[i][3] = Math.min(dp[i - 1][1], dp[i - 1][2]) + colors[i][3];
        }

        int result = Math.min(Math.min(dp[houseCount][1], dp[houseCount][2]), dp[houseCount][3]);
        System.out.println(result);
    }
}