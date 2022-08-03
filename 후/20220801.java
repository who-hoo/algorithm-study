import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(in.readLine());
        int[][] map = new int[N][3];
        int[][] minMemo = new int[N][3];
        int[][] maxMemo = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            minMemo[0][i] = map[0][i];
            maxMemo[0][i] = map[0][i];
        }

        for (int i = 1; i < N; i++) {
            minMemo[i][0] = map[i][0] + Math.min(minMemo[i - 1][0], minMemo[i - 1][1]);
            maxMemo[i][0] = map[i][0] + Math.max(maxMemo[i - 1][0], maxMemo[i - 1][1]);
            minMemo[i][1] = map[i][1] + Math.min(Math.min(minMemo[i - 1][0], minMemo[i - 1][1]), minMemo[i - 1][2]);
            maxMemo[i][1] = map[i][1] + Math.max(Math.max(maxMemo[i - 1][0], maxMemo[i - 1][1]), maxMemo[i - 1][2]);
            minMemo[i][2] = map[i][2] + Math.min(minMemo[i - 1][1], minMemo[i - 1][2]);
            maxMemo[i][2] = map[i][2] + Math.max(maxMemo[i - 1][1], maxMemo[i - 1][2]);
        }

        int minScore = Math.min(Math.min(minMemo[N - 1][0], minMemo[N - 1][1]), minMemo[N - 1][2]);
        int maxScore = Math.max(Math.max(maxMemo[N - 1][0], maxMemo[N - 1][1]), maxMemo[N - 1][2]);
        out.write(maxScore + " " + minScore);

        out.close();
        in.close();
    }
}
