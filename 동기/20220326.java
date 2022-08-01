import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n, m, b;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, board[i][j]);
                max = Math.max(max, board[i][j]);
            }
        }

        int answerSecond = Integer.MAX_VALUE;
        int answerHeight = 0;
        for (int i = min; i <= max; i++) {
            int second = 0;
            int block = b;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int diff = board[j][k] - i;
                    if (diff > 0) {
                        second += diff * 2;
                        block += diff;
                    } else if (diff < 0) {
                        second += Math.abs(diff);
                        block -= Math.abs(diff);
                    }
                }
            }
            if (block < 0) continue;
            if (answerSecond >= second) {
                answerSecond = second;
                answerHeight = i;
            }
        }
        System.out.printf("%d %d", answerSecond, answerHeight);
    }
}
