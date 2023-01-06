import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, m, area = 0;
    static byte[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new byte[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Byte.parseByte(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];

        int result = 0, countOfPainting = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && paper[i][j] == 1) {
                    countOfPainting++;
                    dfs(i, j, visited);
                    result = Math.max(result, area);
                    area = 0;
                }
            }
        }

        System.out.println(countOfPainting);
        System.out.println(result);
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        if (x < 0 || x > n - 1 || y < 0 || y > m - 1 || visited[x][y] || paper[x][y] == 0) {
            return;
        }

        area++;
        visited[x][y] = true;

        dfs(x - 1, y, visited);
        dfs(x + 1, y, visited);
        dfs(x, y - 1, visited);
        dfs(x, y + 1, visited);
    }
}
