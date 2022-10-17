import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static long[][] DP;
    static Queue<Integer> target;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        while (!target.isEmpty()) {
            int x1 = target.poll();
            int y1 = target.poll();
            int x2 = target.poll();
            int y2 = target.poll();

            sb.append(DP[x2][y2] - DP[x1 - 1][y2] - DP[x2][y1 - 1] + DP[x1 - 1][y1 - 1] + "\n");
        }

        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        DP = new long[N + 1][N + 1];
        target = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            split = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                DP[i][j] = DP[i - 1][j] + DP[i][j - 1] - DP[i - 1][j - 1] + Long.parseLong(split[j - 1]);
            }
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                target.add(Integer.parseInt(split[j]));
            }
        }
    }
}
