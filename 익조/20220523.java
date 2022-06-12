import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n, countOfSafeLands;
    static int[][] earth;
    static boolean[][] wateredEarth;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    static class Land {
        int x;
        int y;

        public Land(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        earth = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                earth[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i <= 100; i++) {
            countOfSafeLands = 0;
            wateredEarth = new boolean[n][n];
            water(i, new boolean[n][n]);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!wateredEarth[j][k]) {
                        count(j, k);
                        countOfSafeLands++;
                    }
                }
            }

            result = Math.max(result, countOfSafeLands);
        }

        System.out.println(result);
    }

    public static void water(int target, boolean[][] visited) {
        Queue<Land> queue = new LinkedList<>();
        queue.add(new Land(0, 0));
        if (earth[0][0] <= target) {
            wateredEarth[0][0] = true;
            visited[0][0] = true;
        }

        int nx, ny;

        while (!queue.isEmpty()) {

            Land land = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = land.x + dx[i];
                ny = land.y + dy[i];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1 || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;

                if (earth[nx][ny] <= target) {
                    wateredEarth[nx][ny] = true;
                }

                queue.add(new Land(nx, ny));
            }
        }
    }

    public static void count(int x, int y) {
        wateredEarth[x][y] = true;

        if (x + 1 < n && !wateredEarth[x + 1][y]) {
            count(x + 1, y);
        }
        if (x - 1 > - 1 && !wateredEarth[x - 1][y]) {
            count(x - 1, y);
        }
        if (y + 1 < n && !wateredEarth[x][y + 1]) {
            count(x, y + 1);
        }
        if (y - 1 > - 1 && !wateredEarth[x][y - 1]) {
            count(x, y - 1);
        }
    }
}
