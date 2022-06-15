import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 20220615 {

    public static int[] rowDirection = {-1, 1, 0, 0};
    public static int[] columnDirection = {0, 0, -1, 1};
    public static int[][] map;
    public static boolean[][] visited;
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] target = br.readLine().split(" ");
        n = Integer.parseInt(target[0]);
        m = Integer.parseInt(target[1]);

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < line.length; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(bfs(new Point(0, 0)));
    }

    public static int bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        int count = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            visited[p.row][p.column] = true;
            count++;
            for (int i = 0; i < 4; i++) {
                int nextRow = p.row + rowDirection[i];
                int nextColumn = p.column + columnDirection[i];

                if (nextRow < 0 || nextColumn < 0 || nextRow >= n || nextColumn >= m || visited[nextRow][nextColumn]) {
                    continue;
                }

                if (map[nextRow][nextColumn] == 1) {
                    queue.add(new Point(nextRow, nextColumn));
                }
            }
        }
        return count;
    }

    static class Point {
        private int row;
        private int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
}
