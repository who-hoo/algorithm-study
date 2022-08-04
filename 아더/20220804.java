package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1806_부분합 {

    static int N, S, answer;
    static int[] nums;

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
        if (answer == N + 1) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }

    private static void solve() {
        int R = 0;
        int sum = 0;

        for (int L = 1; L <= N; L++) {
            sum -= nums[L - 1];

            while (R + 1 <= N && sum < S) {
                R++;
                sum += nums[R];
            }

            if (sum >= S) {
                answer = Math.min(answer, R - L + 1);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        answer = N + 1;

        nums = new int[N + 1];

        split = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(split[i - 1]);
        }
    }
}
