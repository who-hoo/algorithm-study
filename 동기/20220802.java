import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][3];
        int[][] dpMin = new int[n][3];
        int[][] dpMax = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            dpMin[0][i] = board[0][i];
            dpMax[0][i] = board[0][i];
        }

        for (int i = 1; i < n; i++) {
            dpMin[i][0] = board[i][0] + Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);
            dpMin[i][1] =
                board[i][1] + Math.min(Math.min(dpMin[i - 1][0], dpMin[i - 1][1]), dpMin[i - 1][2]);
            dpMin[i][2] = board[i][2] + Math.min(dpMin[i - 1][1], dpMin[i - 1][2]);

            dpMax[i][0] = board[i][0] + Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
            dpMax[i][1] =
                board[i][1] + Math.max(Math.max(dpMax[i - 1][0], dpMax[i - 1][1]), dpMax[i - 1][2]);
            dpMax[i][2] = board[i][2] + Math.max(dpMax[i - 1][1], dpMax[i - 1][2]);
        }

        int maxResult = Math.max(Math.max(dpMax[n - 1][0], dpMax[n - 1][1]), dpMax[n - 1][2]);
        int minResult = Math.min(Math.min(dpMin[n - 1][0], dpMin[n - 1][1]), dpMin[n - 1][2]);

        System.out.println(maxResult + " " + minResult);
    }

}
