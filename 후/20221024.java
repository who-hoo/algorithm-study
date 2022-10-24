import java.util.function.BiConsumer;
import java.util.function.Predicate;

class Solution {
    private static final Point[][] map = new Point[11][11];

    private static class Point {

        int row;
        int col;
        boolean visitedUp;
        boolean visitedDown;
        boolean visitedRight;
        boolean visitedLeft;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private enum Command {

        U(-1, 0,
            current -> current.visitedUp,
            (current, next) -> {
                current.visitedUp = true;
                next.visitedDown = true;
            }),
        D(1, 0,
            current -> current.visitedDown,
            (current, next) -> {
                current.visitedDown = true;
                next.visitedUp = true;
            }),
        R(0, 1,
            current -> current.visitedRight,
            (current, next) -> {
                current.visitedRight = true;
                next.visitedLeft = true;
            }
        ),
        L(0, -1,
            current -> current.visitedLeft,
            (current, next) -> {
                current.visitedLeft = true;
                next.visitedRight = true;
            }
        );


        private int dRow;
        private int dCol;
        private Predicate<Point> isNewPath;
        private BiConsumer<Point, Point> move;

        Command(int dRow, int dCol, Predicate<Point> isNewPath, BiConsumer<Point, Point> move) {
            this.dRow = dRow;
            this.dCol = dCol;
            this.isNewPath = isNewPath;
            this.move = move;
        }

        private int nextRow(int currentRow) {
            return currentRow + dRow;
        }

        private int nextCol(int currentCol) {
            return currentCol + dCol;
        }

        private boolean isMovable(Point current) {
            int nextRow = nextRow(current.row);
            int nextCol = nextCol(current.col);
            return 0 <= nextRow && nextRow < map.length
                && 0 <= nextCol && nextCol < map.length;
        }

        private boolean isVisitedPath(Point current) {
            return this.isNewPath.test(current);
        }

        private void move(Point current, Point next) {
            this.move.accept(current, next);
        }
    }

    public int solution(String dirs) {
        int answer = 0;
        initMap();
        Point current = map[5][5];
        for (int i = 0; i < dirs.length(); i++) {
            Command command = Command.valueOf(dirs.substring(i, i + 1));
            if (!command.isMovable(current)) {
                continue;
            }
            Point next = map[command.nextRow(current.row)][command.nextCol(current.col)];
            if (!command.isVisitedPath(current)) {
                answer++;
            }
            command.move(current, next);
            current = map[next.row][next.col];
        }
        return answer;
    }

    private void initMap() {
        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                map[row][col] = new Point(row, col);
            }
        }
    }
}
