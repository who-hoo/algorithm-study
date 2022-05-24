import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int r, c, result = 0;
    static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new String[r][c];

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().split("");
        }

        dfs(0, 0, 0, "");

        System.out.println(result);
    }

    public static void dfs(int x, int y, int count, String visited) {
        if (x < 0 || x > r - 1 || y < 0 || y > c - 1 || visited.contains(board[x][y])) {
            result = Math.max(count, result);
            return;
        }

        visited += board[x][y];
        count++;

        dfs(x + 1, y, count, visited);
        dfs(x - 1, y, count, visited);
        dfs(x, y + 1, count, visited);
        dfs(x, y - 1, count, visited);
    }
}
