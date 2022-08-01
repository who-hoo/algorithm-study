import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static double[] percentages = new double[4];
    static boolean[][] visited = new boolean[30][30];
    static int n;
    static double answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            percentages[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        visited[15][15] = true;
        dfs(15, 15, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count, double result) {
        // 탈출 조건
        if (count == n) {
            answer += result;
            return;
        }

        // dfs
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx <= 0 || ny <= 0 || nx >= 30 || nx >= 30) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, count + 1, result * percentages[i]);
                visited[nx][ny] = false;
            }

        }
    }

}
