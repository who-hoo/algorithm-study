import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int r, c, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int length = (int) Math.pow(2, n);

        search(n, 0, length, 0, length);
    }

    private static void search(int n, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (n == 1) {
            int offset = 0;
            for (int i = rowStart; i < rowEnd; i++) {
                for (int j = colStart; j < colEnd; j++) {
                    if (i == r && j == c) {
                        System.out.println(count + offset);
                        System.exit(0);
                    }
                    offset++;
                }
            }

            return;
        }

        int countOfSector = (int) Math.pow(2, n - 1) * (int) Math.pow(2, n - 1);
        int middleRow = (rowStart + rowEnd) / 2, middleCol = (colStart + colEnd) / 2;

        if (rowStart <= r && middleRow > r  && colStart <= c && middleCol > c) {
            search(n - 1, rowStart, middleRow, colStart, middleCol);
        }
        count += countOfSector;

        if (rowStart <= r && middleRow > r  && middleCol <= c && colEnd > c) {
            search(n - 1, rowStart, middleRow, middleCol, colEnd);
        }
        count += countOfSector;

        if (middleRow <= r && rowEnd > r  && colStart <= c && middleCol > c) {
            search(n - 1, middleRow, rowEnd, colStart, middleCol);
        }
        count += countOfSector;

        if (middleRow <= r && rowEnd > r  && middleCol <= c && colEnd > c) {
            search(n - 1, middleRow, rowEnd, middleCol, colEnd);
        }
        count += countOfSector;
    }
}
