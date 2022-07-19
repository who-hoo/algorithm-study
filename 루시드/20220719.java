package AlgorithmStudy.boj14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int result = Integer.MAX_VALUE;
    static int[][] ability;
    static boolean[] visited;

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        ability = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(split[j]);
            }
        }

        visited = new boolean[n];
        comb(0, n / 2);

        System.out.println(result);
    }

    static void comb(int start, int r) {
        if (r == 0) {
            calculate();
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(i + 1, r - 1);
            visited[i] = false;
        }
    }

    static void calculate() {
        int startSum = 0;
        int endSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    startSum += (ability[i][j] + ability[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    endSum += (ability[i][j] + ability[j][i]);
                }
            }
        }

        result = Math.min(result, Math.abs(startSum - endSum));
    }
}
