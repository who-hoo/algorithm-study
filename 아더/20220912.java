package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1074_Z {

    static int N, r, c, count;
    static boolean findAnswerFlag = false;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        divideAndConquer(0, 0, (int)Math.pow(2, N), (int)Math.pow(2, N), N);
    }

    private static void divideAndConquer(int startRow, int startCol, int endRow, int endCol, int n) {
        if (findAnswerFlag) {
            return ;
        }

        if (n == 1) {
            findAnswerFlag = true;
            for (int i = startRow; i < endRow; i++) {
                for (int j = startCol; j < endCol; j++) {
                    if (i == r && j == c) {
                        System.out.println(count);
                        return ;
                    }
                    count++;
                }
            }
        } else {
            int halfRow = (startRow + endRow) / 2;
            int halfCol = (startCol + endCol) / 2;
            int addCount = (int)(Math.pow(2, n) * Math.pow(2, n)) / 4;
          
            if (r >= startRow && r < halfRow && c >= startCol && c < halfCol) {
                divideAndConquer(startRow, startCol, halfRow, halfCol, n - 1);
            }
            count += addCount;

            if (r >= startRow && r < halfRow && c >= halfCol && c < endCol) {
                divideAndConquer(startRow, halfCol, halfRow, endCol, n - 1); // 2, 4
            }
            count += addCount;

            if (r >= halfRow && r < endRow && c >= startCol && c < halfCol) {
                divideAndConquer(halfRow, startCol, endRow, halfCol, n - 1);
            }
            count += addCount;

            if (r >= halfRow && r < endRow && c >= halfCol && c < endCol) {
                divideAndConquer(halfRow, halfCol, endRow, endCol, n - 1);
            }
            count += addCount;
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        r = Integer.parseInt(split[1]);
        c = Integer.parseInt(split[2]);
    }

}
