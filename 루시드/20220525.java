import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int h, w;
    static char[][] board;
    static boolean[][] chk;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        h = Integer.parseInt(s[0]);
        w = Integer.parseInt(s[1]);

        board = new char[h][w];
        chk = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        chk[0][0] = true;
        DFS(0, 0, "", board[0][0]);

        if (result == 0) {
            result = h * w;
        }
        System.out.println(result);
    }

    private static void DFS(int i, int j, String cur, char value) {

        if (cur.contains(String.valueOf(value))) {
            // cur 길이로 갱신하기
            System.out.println(cur);
            result = Math.max(result, cur.length());
            return;
        }

        cur += value;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w && !chk[nx][ny]) {
                chk[nx][ny] = true;
                DFS(nx, ny, cur, board[nx][ny]);
                chk[nx][ny] = false;
            }
        }
    }
}
