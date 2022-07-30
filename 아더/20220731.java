package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2096_내려가기 {

    static int N, MAX, MIN;
    static int[][] downs, DP;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // 초기화
        DP[0][0] = downs[0][0];
        DP[0][1] = downs[0][1];
        DP[0][2] = downs[0][2];

        // 최댓값 점화식 생성
        for (int i = 1; i < N; i++) {
            DP[i][0] = Math.max(DP[i - 1][0], DP[i - 1][1]) + downs[i][0];
            DP[i][1] = Math.max(Math.max(DP[i - 1][0], DP[i - 1][1]), DP[i - 1][2]) + downs[i][1];
            DP[i][2] = Math.max(DP[i - 1][1], DP[i - 1][2]) + downs[i][2];;
        }

        MAX = Arrays.stream(DP[N - 1]).max().getAsInt();

        // 최솟값 점화식 생성
        for (int i = 1; i < N; i++) {
            DP[i][0] = Math.min(DP[i - 1][0], DP[i - 1][1]) + downs[i][0];
            DP[i][1] = Math.min(Math.min(DP[i - 1][0], DP[i - 1][1]), DP[i - 1][2]) + downs[i][1];
            DP[i][2] = Math.min(DP[i - 1][1], DP[i - 1][2]) + downs[i][2];
        }

        MIN = Arrays.stream(DP[N - 1]).min().getAsInt();

        // 결과 출력
        System.out.println(MAX + " " + MIN);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        downs = new int[N][3];
        DP = new int[N][3];
        MAX = 0;
        MIN = 0;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            downs[i][0] = Integer.parseInt(split[0]);
            downs[i][1] = Integer.parseInt(split[1]);
            downs[i][2] = Integer.parseInt(split[2]);
        }
    }
}
