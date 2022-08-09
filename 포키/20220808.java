import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    public static int[] rowDirection = {1, -1, 0, 0};
    public static int[] columnDirection = {0, 0, 1, -1};
    public static boolean[][] visited;
    public static int xLength,yLength;

    public int solution(int[][] maps) {
        xLength = maps.length;
        yLength = maps[0].length;
        visited = new boolean[maps.length][maps[0].length];


        visited[0][0] = true;
        bfs(maps);

        if (!visited[xLength - 1][yLength - 1]) {
            return -1;
        }
        return maps[xLength - 1][yLength - 1];
    }

    public void bfs(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = cur.x + rowDirection[i];
                int newY = cur.y + columnDirection[i];

                if (newX < 0 || newX >= xLength || newY < 0 || newY >= yLength) {
                    continue;
                }

                if (!visited[newX][newY]&& maps[newX][newY] == 1) {
                    maps[newX][newY] += maps[cur.x][cur.y];
                    visited[newX][newY] = true;
                    q.add(new Point(newX, newY));
                }
            }
        }
    }

    class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
