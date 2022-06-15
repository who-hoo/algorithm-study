package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2178 { //미로 탐색

    private static int n;
    private static int m;
    private static int[][] board;
    private static boolean[][] flagBoard;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numStrings = br.readLine().split(" ");
        n = Integer.parseInt(numStrings[0]);
        m = Integer.parseInt(numStrings[1]);
        board = new int[n][m];
        flagBoard = new boolean[n][m];
        flagBoard[0][0] = true;

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        bfs(0, 0);
        System.out.println(board[n - 1][m - 1]);
    }


    public static void bfs(int x, int y) {
        Queue<PointXY> q = new LinkedList<>();
        q.offer(new PointXY(x, y));
        while (!q.isEmpty()) {
            PointXY point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];


                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (board[nextY][nextX] >= 1 && !flagBoard[nextY][nextX]) {
                        board[nextY][nextX] = board[point.y][point.x] + 1;
                        flagBoard[nextY][nextX] = true;
                        q.offer(new PointXY(nextX, nextY));
                    }
                }
            }
        }

    }

}

class PointXY {
    public int x;
    public int y;

    public PointXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
