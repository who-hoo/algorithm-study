import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n, m, b;
    public static int[][] board;
    public static double answerTime = Double.POSITIVE_INFINITY;
    public static int answerHeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        b = Integer.parseInt(st.nextToken()); // 블록
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int minHeight = 256;
        int maxHeight = -1;
        for (int[] row : board) {
            for (int col : row) {
                if (col < minHeight) {
                    minHeight = col;
                }
                if (col > maxHeight) {
                    maxHeight = col;
                }
            }
        }

        for (int height = minHeight; height <= maxHeight; height++) {
            int currentTime = 0;
            int inventory = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int tempHeight = board[i][j];
                    if (tempHeight < height) {
                        int diff = height - tempHeight;
                        inventory -= diff;
                        currentTime += diff;
                    }
                    if (tempHeight > height) {
                        int diff = tempHeight - height;
                        inventory += diff;
                        currentTime += (2 * diff);
                    }
                }
            }
            if (currentTime <= answerTime && inventory >= 0) {
                answerTime = currentTime;
                if (currentTime == answerTime) {
                    answerHeight = Math.max(answerHeight, height);
                }
            }
        }

        System.out.println((int) answerTime + " " + answerHeight);
    }
}
