import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] dRow = {0, 0, 1, -1}; // 동 서 남 북
    static int[] dCol = {1, -1, 0, 0}; // 동 서 남 북
    static double answer = 0.0;
    static double[] percent = new double[4];
    static boolean[][] visited = new boolean[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        final int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            percent[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        visited[15][15] = true;
        search(N, 0, 15, 15, 1);
        out.write(String.valueOf(answer));

        out.close();
        in.close();
    }

    public static void search(int N, int n, int row, int col, double currentPer) {
        if (n == N) {
            answer += currentPer;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            if (!visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                search(N, n + 1, nextRow, nextCol, currentPer * percent[i]);
                visited[nextRow][nextCol] = false;
            }
        }
    }
}
