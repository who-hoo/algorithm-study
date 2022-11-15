import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {

    private static int n, m, result;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        result = Integer.MAX_VALUE;
        bfs(0, 0);

        result = result == Integer.MAX_VALUE ? -1 : result;
        System.out.println(result);
    }

    public static void bfs(int x, int y) {

        Queue<Worker> q = new LinkedList<>();
        q.add(new Worker(0, 0, 1, false));

        while (!q.isEmpty()) {
            Worker cur = q.poll();

            if (cur.x == n - 1 && cur.y == m - 1) {
                result = Math.min(result, cur.move);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    if (!cur.destroy && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Worker(nx, ny, cur.move + 1, true));
                    }
                }else{
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Worker(nx, ny, cur.move + 1, cur.destroy));
                    }
                }
            }
        }
    }

    static class Worker {
        int x;
        int y;
        int move;
        boolean destroy;

        public Worker(int x, int y, int move, boolean destroy) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.destroy = destroy;
        }
    }
}
