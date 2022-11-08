package baekjoon.main_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {

    private static int n;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static boolean[][] visited;
    public static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        int groupCnt = 0;
        List<Integer> groupSizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] != 0) {
                    groupSizes.add(dfs(i, j, 1));
                    groupCnt++;
                }
            }
        }
        Collections.sort(groupSizes);
        System.out.println(groupCnt);
        for (Integer groupSize : groupSizes) {
            System.out.println(groupSize);
        }

    }

    public static int dfs(int y, int x, int acc) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (0 <= nextY && 0 <= nextX&& nextY < n && nextX < n && !visited[nextY][nextX] && board[nextY][nextX] != 0) {
                acc = dfs(nextY, nextX, ++acc);
            }
        }
        return acc;
    }
}
