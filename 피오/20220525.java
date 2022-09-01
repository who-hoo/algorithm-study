import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] frame;
    private static boolean[][] visited;
    private static int n;
    private static int maxHeight;
    private static int count;
    private static int result;

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        frame = new int[n + 2][n + 2];
        visited = new boolean[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int height = Integer.parseInt(st.nextToken());
                frame[i][j] = height;
                maxHeight = Math.max(maxHeight, height);
            }
        }

        if (maxHeight == 1) {
            System.out.println(1);
        }
        
        for (int i = 1; i < maxHeight; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (dfs(j, k, i)) {
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
            count = 0;
            visited = new boolean[n + 2][n + 2];
        }

        System.out.println(result);
    }
    
    public static boolean dfs(int x, int y, int height) {
        if (!visited[y][x]) {
            if (frame[y][x] > 0 && height < frame[y][x]) {
                visited[y][x] = true;
                for (int i = 0; i < 4; i++) {
                    if (!visited[y + dy[i]][x + dx[i]] && y + dy[i] > 0 && x + dx[i] > 0) {
                        dfs(x + dx[i], y + dy[i], height);
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

}
