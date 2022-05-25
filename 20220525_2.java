import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static List<Integer> visited = new ArrayList<>();
    private static int r;
    private static int c;
    private static int count = 1;
    private static int result = 0;
    private static int[][] frame;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        r = Integer.parseInt(num[0]);
        c = Integer.parseInt(num[1]);
        frame = new int[r][c];

        for (int i = 0; i < r; i++) {
            String[] alphabets = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                frame[i][j] = alphabets[j].charAt(0);
            }
        }

        dfs(0, 0);
        System.out.println(result);

    }

    public static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= c || y >= r) {
            return false;
        }

        if (visited.contains(frame[y][x])) {
            visited.add(frame[y][x]);
            count++;
            for (int i = 0; i < 4; i++) {
                dfs(x + dx[i], y + dy[i]);
            }
            return true;
        }
        return false;
    }
}
