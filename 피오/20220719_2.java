import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[][] board;
    private static int[] team1;
    private static int[] team2;
    private static boolean[] visited;
    private static int answer = 123456789;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

//        for (int i = 0; i < n / 2 + 1; i++) {
            visited = new boolean[n];
            permutation(0, 0);
//        }

        System.out.println(answer);
    }

     public static void permutation(int startNum, int depth) {
        for (int i = startNum; i < n; i++) {
            if (n / 2 == depth) {
                calculate();
                return;
            }
            visited[depth] = true;
            permutation(startNum + 1, depth + 1);
            visited[depth] = false;
        }
    }

    private static void calculate() {
        team1 = new int[n / 2];
        team2 = new int[n / 2];
        int idx1 = 0;
        int idx2 = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
                team1[idx1++] = i;
            } else {
                team2[idx2++] = i;
            }
        }

        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < team1.length; i++) {
            for (int j = 0; j < team1.length; j++) {
                if (visited[i] && visited[j]) {
                    score1 += board[i][j];
                }
                if (!visited[i] && !visited[j]) {
                    score2 += board[i][j];
                }
            }
        }

        answer = Math.min(Math.abs(score1 - score2), answer);
    }

}
