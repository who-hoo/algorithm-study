import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        boolean[][][] visited = new boolean[n + 1][m + 1][2];
        int[][] map = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j - 1)));
            }
        }

        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 1, 0}); // move[3] = 0 : 벽 안 부숨, move[3] = 1 : 벽 부숨
        visited[1][1][0] = true;

        int nx, ny;
        while (!queue.isEmpty()) {

            int[] move = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = move[0] + dx[i];
                ny = move[1] + dy[i];

                if (nx < 1 || nx > n || ny < 1 || ny > m
                    || (move[3] == 0 && visited[nx][ny][0])
                    || (move[3] == 1 && visited[nx][ny][1])
                    || (move[3] == 1 && map[nx][ny] == 1)) {
                    continue;
                }

                if (nx == n && ny == m) {
                    System.out.println(move[2] + 1);
                    return;
                }

                if (map[nx][ny] == 1 && move[3] == 0) {
                    visited[nx][ny][0] = true;
                    queue.add(new int[]{nx, ny, move[2] + 1, move[3] + 1});
                } else if (map[nx][ny] == 0 && move[3] == 0) {
                    visited[nx][ny][0] = true;
                    queue.add(new int[]{nx, ny, move[2] + 1, move[3]});
                } else if (map[nx][ny] == 0 && move[3] == 1) {
                    visited[nx][ny][1] = true;
                    queue.add(new int[]{nx, ny, move[2] + 1, move[3]});
                }
            }
        }

        System.out.println(-1);
    }
}
