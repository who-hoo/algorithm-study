import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static char[][] miro;
    static int n, m, result = 10000;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new char[n][m];

        for (int i = 0; i < n; i++) {
            miro[i] = br.readLine().toCharArray();
        }


        bfs(0, 0);

        System.out.println(result);
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static void bfs(int x, int y) {

        boolean[][] visited = new boolean[n][m];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 1));

        visited[x][y] = true;

        int nx, ny;

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1 || visited[nx][ny] || miro[nx][ny] == '0') {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, node.count + 1));

                if (nx == n - 1 && ny == m - 1) {
                    result = Math.min(result, node.count + 1);
                }
            }
        }

    }
}
