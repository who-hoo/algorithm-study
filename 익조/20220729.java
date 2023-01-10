import java.util.ArrayList;
import java.util.List;

class Solution {

    List<long[]> points = new ArrayList<>();

    public String[] solution(int[][] line) {

        int size = line.length;
        long maxWidth = -10000000001l, maxHeight = -10000000001l, minWidth = 10000000001l, minHeight = 10000000001l;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                long[] point = getPoint(line[i], line[j]);
                if (point != null) {
                    maxWidth = Math.max(maxWidth, point[0]);
                    maxHeight = Math.max(maxHeight, point[1]);
                    minWidth = Math.min(minWidth, point[0]);
                    minHeight = Math.min(minHeight, point[1]);
                    points.add(point);
                }
            }
        }

        if (points.size() == 1) {
            return new String[]{"*"};
        }

        long boardWidth = Math.abs(maxWidth - minWidth) + 1, boardHeight = Math.abs(maxHeight - minHeight) + 1;

        boolean[][] board = new boolean[(int) boardHeight][(int) boardWidth];

        long widthOffset = -minWidth, heightOffset = -minHeight;
        for (long[] point : points) {
            board[(int) (point[1] + heightOffset)][(int) (point[0] + widthOffset)] = true;
        }

        String[] result = new String[(int) boardHeight];
        for (int i = (int) boardHeight - 1, j = 0; i > -1; i--, j++) {
            StringBuilder sb = new StringBuilder();

            for (boolean b : board[i]) {
                if (b) {
                    sb.append('*');
                } else {
                    sb.append('.');
                }
            }

            result[j] = sb.toString();
        }

        return result;
    }

    private long[] getPoint(int[] line1, int[] line2) {

        long A = line1[0], B = line1[1], E = line1[2];
        long C = line2[0], D = line2[1], F = line2[2];

        long numerator = A * D - B * C;
        if (numerator == 0) {
            return null; // 두 직선은 평행 또는 일치
        }

        long denominator1 = (B * F - E * D), denominator2 = (E * C - A * F);

        if (isInteger(denominator1, numerator) && isInteger(denominator2, numerator)) {
            long x = denominator1 / numerator, y = denominator2 / numerator;
            return new long[]{x, y};
        }

        return null; // 교점이 정수가 아닌 경우
    }

    private boolean isInteger(double denominator, double numerator) {
        double temp = denominator / numerator;
        if (temp - (long) (denominator / numerator) == 0) {
            return true;
        }

        return false;
    }
}
