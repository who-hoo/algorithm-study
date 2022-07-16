import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2606 {
    private static int n, m;
    private static boolean[][] map;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new boolean[n + 1][n + 1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            String[] group = br.readLine().split(" ");
            int n1 = Integer.parseInt(group[0]);
            int n2 = Integer.parseInt(group[1]);

            map[n1][n2] = true;
            map[n2][n1] = true;
        }

        dfs(1);
        System.out.println(result);
    }

    public static void dfs(int cur) {
        visited[cur] = true;

        for (int i = 1; i <= n; i++) {
            if (map[cur][i] && !visited[i]) {
                result++;
                dfs(i);
            }
        }
    }
}
