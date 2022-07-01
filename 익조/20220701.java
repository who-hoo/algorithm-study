import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int[][] stickers;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            memo = new int[3][n + 1];
            stickers = new int[3][n + 1];

            for (int j = 1; j < 3; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k < n + 1; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            memo[1][1] = stickers[1][1];
            memo[2][1] = stickers[2][1];

            for (int j = 2; j < n + 1; j++) {
                memo[1][j] = Math.max(memo[2][j - 1], memo[2][j - 2]) + stickers[1][j];
                memo[2][j] = Math.max(memo[1][j - 1], memo[1][j - 2]) + stickers[2][j];
            }

            System.out.println(Math.max(memo[1][n], memo[2][n]));
        }
    }
}
