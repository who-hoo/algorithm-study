package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9019_DSLR {

    static int T, A, B;
    static StringBuilder sb;

    public static void main(String[] args) {
        try {
            input();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            A = Integer.parseInt(split[0]);
            B = Integer.parseInt(split[1]);
            sb = new StringBuilder();

            solve();
            print();
        }
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void solve() {
        // D는 n을 2배로 바꿈, 10000넘어가면 10000으로 나눈 나머지
        // S는 n에서 1 뺀 값! 0에서 1빼면 9999
        // L은 자릿수를 왼쪽으로 시프트
        // R은 자릿수를 오른쪽으로 시프트
        // 마지막 결과값은 Int형으로 변환(계산때는 스트링?)

        // A를 B로 바꾸어야 한다!
        // 최소한의 명령어를 나열한다
        // dfs를 해야되는데 뭐에 대해서 해야하는거지....?

    }

}
