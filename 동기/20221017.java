import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main s = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] arr = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j - 1];
            }
        }

        int[][] num = new int[m][4];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(s.solution(arr, num));
    }

    String solution(int[][] arr, int[][] num) {
        StringBuilder answer = new StringBuilder();
        for (int[] nums : num) {
            int x1 = nums[0];
            int y1 = nums[1];
            int x2 = nums[2];
            int y2 = nums[3];
            int sum = 0;
            for (int startRow = x1; startRow <= x2; startRow++) {
                sum += arr[startRow][y2] - arr[startRow][y1 - 1];
            }
            answer.append(sum).append("\n");
        }

        return answer.toString();
    }

}
