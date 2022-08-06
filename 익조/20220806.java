import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = {0, 0, 1, -1}, dy = {1, -1 , 0 ,0};

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int solution(int[][] maps) {
        int answer = -1;

        int height = maps.length, width = maps[0].length;

        boolean[][] visited = new boolean[height][width];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        int nx, ny;

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];

                if (nx < 0 || nx > height - 1 || ny < 0 || ny > width - 1 || visited[nx][ny] || maps[nx][ny] == 0) {
                    continue;
                }

                if (nx == height - 1 && ny == width - 1) {
                    return node.distance + 1;
                }

                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, node.distance + 1));
            }
        }

        return answer;
    }
}
