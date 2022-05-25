package AlgorithmStudy.boj2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] chk;
    static int count;
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int result = 1;

        for (int height = 0; height <= max; height++) {
            // 해당 높이 이하의 지점을 모두 true로 두기
            chk = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= height) {
                        chk[i][j] = true;
                    }
                }
            }

            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!chk[i][j]) {
                        chk[i][j] = true;
                        count++;
                        DFS(i, j);
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
    }

    private static void DFS(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + i;
            int ny = dy[k] + j;
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !chk[nx][ny]) {
                chk[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }
}
