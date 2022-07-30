package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14889_스타트와링크 {

    static int N, ANSWER;
    static int[] selected;
    static boolean[] isSTeam;
    static int[][] peoples;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(ANSWER);
    }

    private static void solve() {
        // 스타트팀과 링크팀으로 배치한다
        // 팀 능력치 차이의 최소를 구한다
        rec_func(1);
    }

    private static void rec_func(int k) {
        if (k == (N / 2) + 1) {
            ANSWER = Math.min(ANSWER, calculateDiff());
        } else {
            for (int cand = selected[k - 1] + 1; cand <= N; cand++) {
                selected[k] = cand;
                isSTeam[cand] = true;
                rec_func(k + 1);
                selected[k] = 0;
                isSTeam[cand] = false;
            }
        }
    }

    private static int calculateDiff() {
        // true라면 스타트팀, false라면 링크팀
        int sumOfStart = 0;
        int sumOfLink = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isSTeam[i] && isSTeam[j]) {
                    sumOfStart += (peoples[i][j] + peoples[j][i]);
                } else if (!isSTeam[i] && !isSTeam[j]) {
                    sumOfLink += (peoples[i][j] + peoples[j][i]);
                }
            }
        }

        return Math.abs(sumOfStart - sumOfLink);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        peoples = new int[N + 1][N + 1];
        ANSWER = Integer.MAX_VALUE;
        selected = new int[N / 2 + 1];
        isSTeam = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                peoples[i][j] = Integer.parseInt(split[j - 1]);
            }
        }
    }
}
