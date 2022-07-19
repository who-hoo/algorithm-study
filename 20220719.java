package beakjoon.main_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[][] board;
    private static int[] team1;
    private static int[] team2;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //초기화
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < n / 2 + 1; i++) {
            team1 = new int[n / 2];
            team2 = new int[n / 2];
            visited = new boolean[n];
            permutation(i, 0);
            calculate();
        }

    }

    public static void permutation(int startNum, int depth) {
        for (int i = startNum; i < n; i++) {
            if (n / 2 == depth) return;
            team1[depth] = i;
            visited[i] = true;
            permutation(startNum + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static void calculate() {
        permutation2(0);
    }

    public static void permutation2(int depth) {
        for (int i = 0; i < team1.length; i++) {
            if (2 == depth) return; 
            team1[depth] = i;
            visited[i] = true;
            permutation(startNum + 1, depth + 1);
            visited[i] = false;
        }
    }
}
