import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638 {

    public static int n, m;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line.nextToken());
                visited[i][j] = map[i][j] == 1;
            }
        }

        int hour = 0;

        List<int[]> list = new ArrayList<>();
        while (true) {
            list.clear();
            visited = new boolean[n][m];
            checkMap();

            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (map[i][j] == 1 && checkCheese(i, j)) {
                        list.add(new int[]{i, j});
                    }
                }
            }

            if (list.isEmpty()) {
                break;
            }

            for (int[] cheese : list) {
                map[cheese[0]][cheese[1]] =0;
            }
            hour++;
        }

        System.out.println(hour);
    }

    public static void checkMap() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 1) {
                    continue;
                }

                map[nx][ny] = -1;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static boolean checkCheese(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == -1) {
                count++;
            }
        }
        return count >= 2;
    }


}


/*
외부랑 구분한 뒤 외부에 놓여진 치즈들만 0으로 변경 - 1시간 추가
내부에도 0이 있을 수 있기 때문에 -1로 내부와 구분할 것.
해당 작업을 반복
 */
