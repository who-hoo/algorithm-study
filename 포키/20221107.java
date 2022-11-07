import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2667 {

    private static int n;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        int total = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int count = bfs(i, j);
                    total++;
                    list.add(count);
                }
            }
        }

        System.out.println(total);
        Collections.sort(list);
        list.forEach(System.out::println);

    }

    public static int bfs(int x, int y) {
        int house = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            house++;
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return house;

    }



}
