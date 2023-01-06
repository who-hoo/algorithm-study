import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] map;
    static boolean[][] air;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] xEdges, yEdges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        xEdges = new int[][]{{0, m}, {n - 1, m}};
        yEdges = new int[][]{{0, n}, {m - 1, n}};

        map = new int[n][m];
        air = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        boolean flag = true;
        while (true) {
            setAir();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && isExposed(i, j)) {
                        map[i][j] = 0;
                        flag = false;
                    }
                }
            }

            if (flag) {
                break;
            }

            result++;
            flag = true;
        }

        System.out.println(result);
    }

    private static void setAir() {
        boolean[][] visited = new boolean[n][m];

        for (int[] xEdge : xEdges) {
            for (int i = 0; i < xEdge[1]; i++) {
                if (!visited[xEdge[0]][i] && map[xEdge[0]][i] == 0) {
                    spread(xEdge[0], i, visited);
                    return;
                }
            }
        }

        for (int[] yEdge : yEdges) {
            for (int i = 0; i < yEdge[1]; i++) {
                if (!visited[i][yEdge[0]] && map[i][yEdge[0]] == 0) {
                    spread(i, yEdge[0], visited);
                    return;
                }
            }
        }
    }

    private static void spread(int x, int y, boolean[][] visited) {
        if (x < 0 || x > n - 1 || y < 0 || y > m - 1 || visited[x][y] || map[x][y] == 1) {
            return;
        }

        visited[x][y] = true;
        air[x][y] = true;

        spread(x, y + 1, visited);
        spread(x, y - 1, visited);
        spread(x + 1, y, visited);
        spread(x - 1, y, visited);
    }

    private static boolean isExposed(int x, int y) {
        int nx, ny, count = 0;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) {
                continue;
            }

            if (air[nx][ny]) {
                count++;
            }
        }

        return count > 1;
    }
}
