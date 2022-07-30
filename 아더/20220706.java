import java.io.*;

public class Main {

    static int T, N;
    static int[][] stickers, DP;
    static StringBuilder sb;

    public static void main(String[] args) {
        try {
            input();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
        System.out.println(sb);
    }

    static void solve() {
        // 초기값 셋팅
        DP[0][0] = stickers[0][0];
        DP[1][0] = stickers[1][0];
        if (N > 1) {
            DP[0][1] = DP[1][0] + stickers[0][1];
            DP[1][1] = DP[0][0] + stickers[1][1];
        }

        // 점화식 생성 및 DP 배열 채우기
        for (int i = 2; i < N; i++) {
            DP[0][i] = Math.max(DP[1][i - 1], DP[1][i - 2]) + stickers[0][i];
            DP[1][i] = Math.max(DP[0][i - 1], DP[0][i - 2]) + stickers[1][i];
        }

        // sb에 추가
        sb.append(Math.max(DP[0][N - 1], DP[1][N - 1])).append("\n");
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];
            DP = new int[2][N];

            for (int i = 0; i < 2; i++) {
                String[] split = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    stickers[i][j] = Integer.parseInt(split[j]);
                }
            }
            solve();
        }
    }
}
