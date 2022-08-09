package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1405_미친로봇 {

    static int N;
    static double ANSWER;
    static double[] percentages;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] map;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        map[15][15] = true;
        dfs(15, 15, 0, 1);

        System.out.println(ANSWER);
    }

    private static void dfs(int x, int y, int k, double result) {
        if (k == N) {
            ANSWER += result;
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= 30 || ny >= 30) {
                    continue;
                }

                if (!map[nx][ny]) {
                    map[nx][ny] = true;
                    dfs(nx, ny, k + 1, result * percentages[i]);
                    map[nx][ny] = false;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        percentages = new double[4];

        for (int i = 1; i <= 4; i++) {
            percentages[i - 1] = Double.parseDouble(split[i]) * 0.01;
        }

        map = new boolean[30][30];
    }
}
