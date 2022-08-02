import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static final int X = 0;
    static final int Y = 1;
    static final int N = 2;

    static class Point {

        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        // 1. 모든 교점을 구한다.
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] lineA = line[i];
                int[] lineB = line[j];
                if (lineA[X] * lineB[Y] - lineA[Y] * lineB[X] != 0) {
                    double x = (double) (lineA[Y] * lineB[N] - lineA[N] * lineB[Y])
                        / (double) (lineA[X] * lineB[Y] - lineA[Y] * lineB[X]);
                    double y = (double) (lineA[N] * lineB[X] - lineA[X] * lineB[N])
                        / (double) (lineA[X] * lineB[Y] - lineA[Y] * lineB[X]);
                    if (x % 1 == 0 && y % 1 == 0) {
                        points.add(new Point((long) x, (long) y));
                        minX = Math.min(minX, (long) x);
                        minY = Math.min(minY, (long) y);
                        maxX = Math.max(maxX, (long) x);
                        maxY = Math.max(maxY, (long) y);
                    }
                }
            }
        }

        // 2. 모든 교점의 minX, minY, maxX, maxY를 구하여 격자판을 초기화한다.
        char[][] board = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }

        // 3. 별찍기
        for (Point point : points) {
            board[(int) (maxY - point.y)][(int) (maxX - point.x)] = '*';
        }
        String[] answer = new String[board.length];
        for (int i = 0; i < board.length; i++) {
            answer[i] = String.valueOf(board[i]);
        }
        return answer;
    }
}
