import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7562 {

    private static int[] mx = {2, 2, -2, -2, -1, 1, -1, 1};
    private static int[] my = {1, -1, 1, -1, 2, 2, -2, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        while (cnt > 0) {
            cnt--;
            Queue<Location> queue = new LinkedList<>();
            int length = sc.nextInt();
            boolean[][] chessBoard = new boolean[length][length];

            Location start = new Location(sc.nextInt(), sc.nextInt(), 0);
            Location destination = new Location(sc.nextInt(), sc.nextInt(), 0);
            queue.add(start);
            chessBoard[start.getX()][start.getY()] = true;

            int result = bfs(queue, chessBoard, destination);
            System.out.println(result);
        }
    }

    private static int bfs(Queue<Location> queue, boolean[][] board, Location destination) {
        while (!queue.isEmpty()) {
            Location poll = queue.poll();

            if (poll.getX() == destination.getX() && poll.getY() == destination.getY()) {
                return poll.getCount();
            }

            for (int i = 0; i < 8; i++) {
                int x = poll.getX() + mx[i];
                int y = poll.getY() + my[i];

                if(x < 0 || y < 0 || x >= board.length || y >= board.length || board[x][y]==true) continue;
                board[x][y] = true;
                queue.add(new Location(x, y, poll.getCount() + 1));
            }
        }
        return 0;
    }
}

class Location {
    private int x;
    private int y;
    private int count;

    public Location(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCount() {
        return count;
    }
}


//확인해야하는 위치
//x+2, y+1 / x+2 y-1
//x-2, y+1 / x-2 y-1
//x-1, y+2 / x+1 y+2
//x-1, y-2 / x+1 y-2
