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
    private static int answer = Integer.MAX_VALUE;

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

        visited = new boolean[n];
        permutation(0, 0);

        System.out.println(answer);
    }

     public static void permutation(int startNum, int depth) {
        if (n / 2 == depth) {
            calculate();
            return;
        }
        for (int i = startNum; i < n; i++) {
            visited[i] = true;
            permutation(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static void calculate() {
        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    score1 += board[i][j];
                    score1 += board[j][i];
                }
                if (!visited[i] && !visited[j]) {
                    score2 += board[i][j];
                    score2 += board[j][i];
                }
            }
        }

        answer = Math.min(Math.abs(score1 - score2), answer);
    }

}
