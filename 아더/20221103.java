package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1926_그림 {

    static int n, m, spaceCnt;;
    static int[][] paper, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static ArrayList<Integer> spaceCntList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(spaceCntList.size());
        if (spaceCntList.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(spaceCntList.stream()
                .mapToInt(spaceCnt -> spaceCnt)
                .max()
                .getAsInt());
        }
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    spaceCntList.add(spaceCnt);
                    spaceCnt = 0;
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        spaceCnt++;
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (paper[nx][ny] == 0) continue;
            if (visited[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
