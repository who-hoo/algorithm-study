import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    int count = 0;
    int sum = 0;
    boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        StringTokenizer st;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution s = new Solution();
        System.out.println(s.solution(n, m, map));
    }

    public String solution(int n, int m, int[][] map) {
        StringBuilder sb = new StringBuilder();
        visited = new boolean[n][m];
        int maxWidth = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    dfs(map, i, j);
                    sum++;
                    maxWidth = Math.max(count, maxWidth);
                }
            }
        }
        sb.append(sum).append("\n");
        sb.append(maxWidth);
        return sb.toString();
    }

    private void dfs(int[][] map, int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny] == 1) {
                dfs(map, nx, ny);
            }
        }
    }

}
