import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        
        if (n - 1 == 0 && m - 1 == 0) {
            System.out.println(1);
            System.exit(0);
        }

        StringTokenizer st;
        String[][] map = new String[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map[i] = st.nextToken().split("");
        }

        Main s = new Main();
        System.out.println(s.solution(n, m, map));

    }

    public int solution(int n, int m, String[][] map) {
        visited = new boolean[n][m][2];
        int[][] dist = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 이동할 위치가 벽이라면
                // [x][y][0] = 벽을 깨지 않고 이동
                // [x][y][1] = 벽을 깨고 이동
                if (map[nx][ny].equals("1")) {
                    if (current[2] == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        dist[nx][ny] = dist[current[0]][current[1]] + 1; // 이동거리 업데이트
                        q.offer(new int[]{nx, ny, 1});
                    }
                } else {
                    if (!visited[nx][ny][current[2]]) {
                        visited[nx][ny][current[2]] = true;
                        dist[nx][ny] = dist[current[0]][current[1]] + 1;
                        q.offer(new int[]{nx, ny, current[2]});
                    }
                }

                if (nx == n - 1 && ny == m - 1) {
                    return dist[nx][ny] + 1;
                }
            }
        }
        return -1;
    }

}
