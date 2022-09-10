import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static byte[][][] board;
    static int[] dx = {1, -1, 0, 0, 0, 0}, dy = {0, 0, 1, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};
    static int m, n, h, days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new byte[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Byte.parseByte(st.nextToken());
                }
            }
        }

        boolean[][][] visited = new boolean[h][n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 1) {
                        queue.add(new int[]{j, k, i, 0});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        spread(visited, queue);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(days);
    }

    private static void spread(boolean[][][] visited, Queue<int[]> queue) {
        int nx, ny, nz;

        while (!queue.isEmpty()) {

            int[] positions = queue.poll();

            for (int i = 0; i < 6; i++) {
                nx = positions[0] + dx[i];
                ny = positions[1] + dy[i];
                nz = positions[2] + dz[i];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1 || nz < 0 || nz > h - 1 ||
                    board[nz][nx][ny] != 0 || visited[nz][nx][ny]) {
                    continue;
                }

                board[nz][nx][ny] = 1;
                visited[nz][nx][ny] = true;
                days = Math.max(days, positions[3] + 1);
                queue.add(new int[]{nx, ny, nz, positions[3] + 1});
            }
        }
    }
}
