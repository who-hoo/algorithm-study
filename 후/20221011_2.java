import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int minusOneCount = 0;
    static int zeroCount = 0;
    static int plusOneCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(in.readLine());

        int[][] paper = new int[N][N];
        StringTokenizer tokenizer;
        for (int row = 0; row < N; row++) {
            tokenizer = new StringTokenizer(in.readLine());
            for (int col = 0; col < N; col++) {
                paper[row][col] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        divideConquer(paper, 0, 0, N);

        System.out.println(minusOneCount);
        System.out.println(zeroCount);
        System.out.println(plusOneCount);
    }

    private static void divideConquer(int[][] paper, int row, int col, int size) {
        System.out.println("row = " + row);
        System.out.println("col = " + col);
        System.out.println("size = " + size);
        if (isAllSame(paper, row, col, size)) {
            count(paper[row][col]);
        } else {
            int dividedSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divideConquer(paper, row + dividedSize * i, col + dividedSize * j, dividedSize);
                }
            }
        }
    }

    private static boolean isAllSame(int[][] paper, int row, int col, int size) {
        int num = paper[row][col];
        for (int i = 0; i < row + size; i++) {
            for (int j = 0; j < col + size; j++) {
                if (paper[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void count(int paperNum) {
        switch (paperNum) {
            case -1:
                minusOneCount++;
                break;
            case 0:
                zeroCount++;
                break;
            case 1:
                plusOneCount++;
                break;
            default:
                break;
        }
    }
}
