package AlgorithmStudy.boj7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {1, 2, -1, 2, 1, -2, -1, -2};
    static int[] dy = {2, 1, 2, -1, -2, 1, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNumber = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int size, nightX, nightY, targetX, targetY;
        while (testNumber-- > 0) {
            size = Integer.parseInt(br.readLine());
            String[] nightPosition = br.readLine().split(" ");
            nightX = Integer.parseInt(nightPosition[0]);
            nightY = Integer.parseInt(nightPosition[1]);

            String[] targetPosition = br.readLine().split(" ");
            targetX = Integer.parseInt(targetPosition[0]);
            targetY = Integer.parseInt(targetPosition[1]);

            if (nightX == targetX && nightY == targetY) {
                sb.append(0).append("\n");
                continue;
            }
            sb.append(BFS(size, nightX, nightY, targetX, targetY)).append("\n");
        }
        System.out.println(sb);
    }

    private static int BFS(int size, int nightX, int nightY, int targetX, int targetY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(nightX, nightY));
        int result = 0;
        boolean[][] chk = new boolean[size][size];
        chk[nightX][nightY] = true;

        while (!queue.isEmpty()) {
            int tmpSize = queue.size();
            result++;
            for (int i = 0; i <tmpSize; i++) {
                Point poll = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];
                    if (nx == targetX && ny == targetY) {
                        return result;
                    }
                    if (nx < size && nx >= 0 && ny < size && ny >= 0 && !chk[nx][ny]) {
                        chk[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return result;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
