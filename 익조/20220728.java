import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] maxMemo = new int[n][3];
        int[][] minMemo = new int[n][3];

        maxMemo[0][0] = board[0][0];
        maxMemo[0][1] = board[0][1];
        maxMemo[0][2] = board[0][2];

        minMemo[0][0] = board[0][0];
        minMemo[0][1] = board[0][1];
        minMemo[0][2] = board[0][2];

        for (int i = 1; i < n; i++) {
            maxMemo[i][0] = Math.max(maxMemo[i-1][0], maxMemo[i-1][1]) + board[i][0];
            maxMemo[i][1] = Math.max(maxMemo[i-1][0], Math.max(maxMemo[i-1][1], maxMemo[i-1][2])) + board[i][1];
            maxMemo[i][2] = Math.max(maxMemo[i-1][1], maxMemo[i-1][2]) + board[i][2];

            minMemo[i][0] = Math.min(minMemo[i-1][0], minMemo[i-1][1]) + board[i][0] ;
            minMemo[i][1] = Math.min(minMemo[i-1][0], Math.min(minMemo[i-1][1], minMemo[i-1][2])) + board[i][1];
            minMemo[i][2] = Math.min(minMemo[i-1][1], minMemo[i-1][2]) + board[i][2];
        }

        System.out.printf("%d %d",
            Math.max(maxMemo[n-1][0], Math.max(maxMemo[n-1][1], maxMemo[n-1][2])),
            Math.min(minMemo[n-1][0], Math.min(minMemo[n-1][1], minMemo[n-1][2]))
        );
    }
}
