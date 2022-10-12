import java.io.*;

public class Main {

    static int N;
    static int[] answers;
    static int[][] paper;


    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        divideConquer(0, 0, N);

        System.out.println(answers[0]);
        System.out.println(answers[1]);
        System.out.println(answers[2]);
    }

    private static void divideConquer(int row, int col, int size) {
        if (isAllSameNumber(row, col, size)) {
            answers[paper[row][col] + 1] += 1;
        } else {
            int newSize = size / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divideConquer(row + newSize * i, col + newSize * j, newSize);
                }
            }
        }
    }

    private static boolean isAllSameNumber(int row, int col, int size) {
        int target = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != target) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        answers = new int[3];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
