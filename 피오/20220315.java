package beakjoon.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


public class Main_7562 { //나이트의 이동

    private static int X;
    private static int Y;

    private static int targetX;
    private static int targetY;

    private static int[][] board;
    private static int boardLength;

    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            boardLength = sc.nextInt();
            board = new int[boardLength][boardLength];
            X = sc.nextInt();
            Y = sc.nextInt();

            board[Y][X] = 1;

            targetX = sc.nextInt();
            targetY = sc.nextInt();
            System.out.println(bfs(X, Y));
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= boardLength || ny < 0 || ny >= boardLength) {
                    continue;
                }

                if (board[ny][nx] == 0) {
                    board[ny][nx] = board[y][x] + 1;
                    q.offer(new Node(nx, ny));
                }

                if (ny == targetY && nx == targetX) {
                    return board[ny][nx] - 1; 
                }
            }
        }
        return 0;
    }

}
