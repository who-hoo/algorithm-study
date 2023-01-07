import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper;
    static int zeroCount = 0, plusCount = 0, minusCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, n, n);

        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(plusCount);
    }

    private static void divide(int rowStart, int colStart, int rowEnd, int colEnd) {
        if (verify(rowStart, colStart, rowEnd, colEnd)) {
            return;
        }

        if (rowEnd - rowStart == 1 && colEnd - colStart == 1) {
            return;
        }

        int oneThirdRow = rowStart + (rowEnd - rowStart) / 3;
        int oneThirdCol = colStart + (colEnd - colStart) / 3;
        int twoThirdRow = rowStart + (rowEnd - rowStart) * 2 / 3;
        int twoThirdCol = colStart + (colEnd - colStart) * 2 / 3;

        divide(rowStart, colStart, oneThirdRow, oneThirdCol);
        divide(oneThirdRow, colStart, twoThirdRow, oneThirdCol);
        divide(twoThirdRow, colStart, rowEnd, oneThirdCol);

        divide(rowStart, oneThirdCol, oneThirdRow, twoThirdCol);
        divide(oneThirdRow, oneThirdCol, twoThirdRow, twoThirdCol);
        divide(twoThirdRow, oneThirdCol, rowEnd, twoThirdCol);

        divide(rowStart, twoThirdCol, oneThirdRow, colEnd);
        divide(oneThirdRow, twoThirdCol, twoThirdRow, colEnd);
        divide(twoThirdRow, twoThirdCol, rowEnd, colEnd);
    }

    private static boolean verify(int rowStart, int colStart, int rowEnd, int colEnd) {
        int zeroCount = 0, minusCount = 0, plusCount = 0;

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (paper[i][j] == 0) {
                    zeroCount++;
                } else if (paper[i][j] == 1) {
                    plusCount++;
                } else {
                    minusCount++;
                }

                if (zeroCount > 0 && plusCount > 0  || plusCount > 0 && minusCount > 0 || zeroCount > 0 && minusCount > 0) {
                    return false;
                }
            }
        }

        if (zeroCount > 0) {
            Main.zeroCount++;
        } else if (plusCount > 0) {
            Main.plusCount++;
        } else if (minusCount > 0) {
            Main.minusCount++;
        }

        return true;
    }
}
