import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14889 {
    public static int n  = 0;
    public static int[][] map;
    public static boolean[] visited;
    public static int result = 100000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] l = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(l[j]);
            }
        }
        dfs(0, 0);
        System.out.println(result);


    }

    private static void dfs(int index, int count) {
        if (count == n / 2) {
            calculate();
            return;
        }
        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;

            }
        }
    }

    private static void calculate() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if (visited[i] && visited[j]) start += map[i][j] + map[j][i];
                else if (!visited[i]&& !visited[j]) link += map[i][j] + map[j][i];
            }
        }

        int num = Math.abs(start - link);

        if (num == 0) {
            System.out.println(num);
            System.exit(0);
        }
        result = Math.min(result, num);

    }
}
