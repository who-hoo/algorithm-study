import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    boolean[][] visited;
    int count;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split("");
        }

        Main s = new Main();
        System.out.println(s.solution(arr));
    }

    private String solution(String[][] arr) {
        // 반환 : 총 단지수, 단지내 집의 수를 오름차순 정렬하여서
        StringBuilder sb = new StringBuilder();
        visited = new boolean[n][n];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j].equals("1")) {
                    count = 0;
                    dfs(i, j, arr);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");

        for (Integer value : list) {
            sb.append(value).append("\n");
        }

        return sb.toString();
    }

    private void dfs(int x, int y, String[][] map) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny].equals("1")) {
                dfs(nx, ny, map);
            }
        }
    }

}
