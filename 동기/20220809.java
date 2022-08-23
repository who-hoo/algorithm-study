import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[] dx = {-1, 1, 0, 0 };
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int n;
    int m;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        return bfs(0, 0, maps);
    }

    private int bfs(int x, int y, int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x == n - 1 && node.y == m - 1) {
                return node.cost;
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, node.cost + 1));
                }
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

}
