import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int X = 0;
    public static int Y = 1;
    public static int COUNT = 2;
    public static int[][] moveCase = new int[][]{
        {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
        {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static int bfs(int[][] board, boolean[][] visited, int x, int y, int targetX,
        int targetY) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(x, y, 0));
        while (!queue.isEmpty()) {
            List<Integer> point = queue.poll();
            int currentX = point.get(X);
            int currentY = point.get(Y);
            board[currentX][currentY] = point.get(COUNT);
            if (currentX == targetX && currentY == targetY) {
                return board[targetX][targetY];
            }
            for (int[] mc : moveCase) {
                int nextX = currentX + mc[X];
                int nextY = currentY + mc[Y];
                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board.length) {
                    continue;
                }
                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(List.of(nextX, nextY, point.get(COUNT) + 1));
                }
            }
        }
        return board[targetX][targetY];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCaseCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCaseCount; i++) {
            int boardSize = Integer.parseInt(br.readLine());
            int[][] board = new int[boardSize][boardSize];
            boolean[][] visited = new boolean[boardSize][boardSize];
            st = new StringTokenizer(br.readLine());
            int currentX = Integer.parseInt(st.nextToken());
            int currentY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            sb.append(bfs(board, visited, currentX, currentY, targetX, targetY));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
