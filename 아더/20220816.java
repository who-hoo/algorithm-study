package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1107_리모컨 {

    static int N, M, ANSWER;
    static int[] BROKEN_NUMS;

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
        // 시작채널은 100
        // N까지 이동해야함
        // 채널은 0부터 무한대

        // 100번 채널일 경우 정답 0
        if (N == 100) {
            return ;
        }




    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        BROKEN_NUMS = new int[M];
        ANSWER = 0;

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            BROKEN_NUMS[i] = Integer.parseInt(split[i]);
        }
    }

}
