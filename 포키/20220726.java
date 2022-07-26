import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1405 {

    public static int[] rowDirection = {0, 0, 1, -1};
    public static int[] columnDirection = {1, -1, 0, 0};
    public static double[] directionPercent = new double[4];
    public static boolean[][] visited = new boolean[30][30];
    public static double result = 0;
    public static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        for (int i = 0; i < 4; i++) {
            directionPercent[i] = Double.parseDouble(input[i+1]) * 0.01;
        }

        dfs(15, 15, 0, 1);
        System.out.println(result);

    }

    public static void dfs(int r, int c, int moveCount, double percent) {

        if (moveCount == n) {
            result += percent;
            return;
        }

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int newR = r + rowDirection[i];
            int newC = c + columnDirection[i];

            if (newR < 0 || newR > 30|| newC > 30 || newC < 0) {
                continue;
            }

            if (!visited[newR][newC]) {
                visited[newR][newC] = true;
                dfs(newR, newC, moveCount + 1, percent * directionPercent[i]);
                visited[newR][newC] = false;
            }
        }
    }
}
