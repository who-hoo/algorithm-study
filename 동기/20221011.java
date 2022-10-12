import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int minus;
    int zero;
    int plus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main s = new Main();
        System.out.println(s.solution(N, arr));
    }

    public String solution(int N, int[][] arr) {
        StringBuilder answer = new StringBuilder();
        int length = arr.length;

        recursive(arr, 0, 0, length);
        answer.append(minus).append("\n").append(zero).append("\n").append(plus);
        return answer.toString();
    }

    private void recursive(int[][] arr, int x, int y, int length) {
        if (length == 1) {
            if (arr[x][y] == -1) {
                minus++;
                return;
            } else if (arr[x][y] == 0) {
                zero++;
                return;
            } else {
                plus++;
                return;
            }
        }

        if (!checked(arr, x, y, length)) {
            recursive(arr, x, y, length / 3);
            recursive(arr, x, y + length / 3, length / 3);
            recursive(arr, x + length / 3, y, length / 3);
            recursive(arr, x + length / 3, y + length / 3, length / 3);
            recursive(arr, x, y + length / 3 * 2, length / 3);
            recursive(arr, x + length / 3 * 2, y, length / 3);
            recursive(arr, x + length / 3, y + length / 3 * 2, length / 3);
            recursive(arr, x + length / 3 * 2, y + length / 3, length / 3);
            recursive(arr, x + length / 3 * 2, y + length / 3 * 2, length / 3);
        } else {
            if (arr[x][y] == -1) {
                minus++;
            } else if (arr[x][y] == 0) {
                zero++;
            } else {
                plus++;
            }
        }
    }

    private boolean checked(int[][] arr, int x, int y, int length) {
        int firstValue = arr[x][y];
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != firstValue) {
                    return false;
                }
            }
        }
        return true;
    }
}
