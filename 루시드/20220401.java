import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                min = Math.min(min, value);
                max = Math.max(max, value);
                board[i][j] = value;
            }
        }

        int removeBlock;
        int addBlock;
        int curValue;
        int time = Integer.MAX_VALUE;
        int result = 0;

        for (int i = min; i <= max; i++) {
            removeBlock = 0;
            addBlock = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    curValue = board[j][k];
                    // 지워지는 블록
                    if (curValue >= i) {
                        removeBlock += curValue - i;
                        continue;
                    }
                    // 더해야할 블록
                    addBlock += i - curValue;
                }
            }
            // 필요한 블록보다 더 수가 많다면 가능
            if (removeBlock + B >= addBlock) {
                int nowResult = (removeBlock * 2) + addBlock;
                if (nowResult <= time) {
                    time = nowResult;
                    result = i;
                }
            }
        }
        System.out.println(time + " " + result);
    }
}
