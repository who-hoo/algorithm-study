import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] board;
    static Map<Integer, Integer> check = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        check.put(0, 0);
        check.put(-1, 0);
        check.put(1, 0);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        gogo(0, 0, n);
        System.out.println(check.get(-1));
        System.out.println(check.get(0));
        System.out.println(check.get(1));
    }

    public static void gogo(int startY, int startX, int length) {
        int startNumber = board[startY][startX];
        if (isAllSameNumber(startY, startX, length, startNumber)) {
            check.computeIfPresent(startNumber, (k, v) -> v + 1);
            return;
        }

        int nextLength = length / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gogo(startY + i * nextLength, startX + j * nextLength, nextLength);
            }
        }
    }

    private static boolean isAllSameNumber(int startY, int startX, int length, int startNumber) {
        for (int i = startY; i < startY + length; i++) {
            for (int j = startX; j < startX + length; j++) {
                if (board[i][j] != startNumber) {
                    return false;
                }
            }
        }
        return true;
    }
}
