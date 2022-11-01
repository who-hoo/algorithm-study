package baekjoon.main_2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] board;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int n;
    private static int m;
    private static int remainder = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new int[n][m];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    remainder++;
                }
            }
        }

        while (true) {
            
            
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    
                    if (isOverExposedToAir(n, m)) {

                    }
                }
            }

        }
    }

    private static boolean isOverExposedToAir(int n, int m) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (board[n + dy[i]][m + dx[i]] == 1) {
                count++;
            }
        }
        return 2 <= count;
    }
}
