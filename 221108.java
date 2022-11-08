package baekjoon.main_1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new int[n][m];
        visited = new boolean[n][m];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cntOfPaints = 0;
        int maxSizeOfPaint = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    maxSizeOfPaint = Math.max(maxSizeOfPaint, dfs(i, j, 1));
                    cntOfPaints++;
                }
            }
        }
        System.out.println(cntOfPaints);
        System.out.println(maxSizeOfPaint);
    }

    public static int dfs(int y, int x, int acc) {
        visited[y][x] = true;
 
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (0 <= nextY && 0 <= nextX && nextY < n && nextX < m
                && !visited[nextY][nextX] && board[nextY][nextX] == 1) {
                acc = dfs(nextY, nextX, ++acc);
            }
        }
        return acc;
    }
}
