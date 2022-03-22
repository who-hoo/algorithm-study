import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 나이트가 이동할 수 있는 좌표
    static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    static int[][] board;
    static boolean[][] visited;
    static int l;
    static int x, y, goalX, goalY;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCaseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            visited = new boolean[l][l];

            // 나이트의 현재 위치 좌표
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // 나이트의 골 지점 좌표
            st = new StringTokenizer(br.readLine(), " ");
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            bfs(new Node(x, y));
            System.out.println(board[goalX][goalY]);
        }
    }

    private static void bfs(Node node) {

        if (node.x == goalX && node.y == goalY) {
            return;
        }

        // 입력 받은 현재 좌표에서 시작하기 위해 true로
        visited[node.x][node.y] = true;

        queue.add(node);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pollX = poll.x;
            int pollY = poll.y;

            for (int j = 0; j < dx.length; j++) {
                int nx = pollX + dx[j];
                int ny = pollY + dy[j];

                if (nx >= 0 && nx < l && ny >= 0 && ny < l && !visited[nx][ny]) {

                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;

                    //전의 이동 횟수에 +1 씩 더해주며 이동 횟수를 증가시켜준다.
                    board[nx][ny] = board[pollX][pollY] + 1;
                }
            }
        }
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
