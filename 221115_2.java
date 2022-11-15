package baekjoon.main_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n, m;
    private static int[][] board;
    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{1, 0, -1, 0};
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[0]);

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        
    }
}
