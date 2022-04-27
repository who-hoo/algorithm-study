import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] room;

    static int count0(int[][] room) {
        int count = 0;
        for (int[] row : room) {
            for (int col : row) {
                if (col == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static int[][] deepCopy() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = room[i][j];
            }
        }
        return copy;
    }

    static int[][] left(int row, int col, int[][] copiedRoom) {
        for (int i = col; i >= 0; i--) { // left
            if (copiedRoom[row][i] == 6) {
                break;
            }
            if (copiedRoom[row][i] == 0) {
                copiedRoom[row][i] = -1;
            }
        }
        return copiedRoom;
    }

    static int[][] right(int row, int col, int[][] copiedRoom) {
        for (int i = col; i < M; i++) { // right
            if (copiedRoom[row][i] == 6) {
                break;
            }
            if (copiedRoom[row][i] == 0) {
                copiedRoom[row][i] = -1;
            }
        }
        return copiedRoom;
    }

    static int[][] up(int row, int col, int[][] copiedRoom) {
        for (int i = row; i >= 0; i--) { // up
            if (copiedRoom[i][col] == 6) {
                break;
            }
            if (copiedRoom[i][col] == 0) {
                copiedRoom[i][col] = -1;
            }
        }
        return copiedRoom;
    }

    static int[][] down(int row, int col, int[][] copiedRoom) {
        for (int i = row; i < N; i++) { // down
            if (copiedRoom[i][col] == 0) {
                break;
            }
            if (copiedRoom[i][col] == 6) {
                copiedRoom[i][col] = -1;
            }
        }
        return copiedRoom;
    }

    static void cctv1(int row, int col) {
        int min = N * M;
        int direction = 0; // 1:right, 2:down, 3:left, 4:up
        int[][] copied1 = deepCopy();
        right(row, col, copied1);
        if (count0(copied1) < min) {
            direction = 1;
        }
        int[][] copied2 = deepCopy();
        down(row, col, copied2);
        if (count0(copied2) < min) {
            direction = 2;
        }
        int[][] copied3 = deepCopy();
        left(row, col, copied3);
        if (count0(copied3) < min) {
            direction = 3;
        }
        int[][] copied4 = deepCopy();
        up(row, col, copied4);
        if (count0(copied4) < min) {
            direction = 4;
        }
        switch (direction) {
            case 1:
                room = copied1;
            case 2:
                room = copied2;
            case 3:
                room = copied3;
            case 4:
                room = copied4;
        }
    }

    static void cctv2(int row, int col) {
        int min = N * M;
        int direction = 0; // 1:left&right, 2:up&down
        int[][] copied1 = deepCopy();
        left(row, col, copied1);
        right(row, col, copied1);
        if (count0(copied1) < min) {
            direction = 1;
        }
        int[][] copied2 = deepCopy();
        up(row, col, copied2);
        down(row, col, copied2);
        if (count0(copied2) < min) {
            direction = 2;
        }
        switch (direction) {
            case 1:
                room = copied1;
            case 2:
                room = copied2;
        }
    }

    static void cctv3(int row, int col) {
        int min = N * M;
        int direction = 0; // 1:up&right, 2:right&down, 3:down&left, 4:left&up
        int[][] copied1 = deepCopy();
        up(row, col, copied1);
        right(row, col, copied1);
        if (count0(copied1) < min) {
            direction = 1;
        }
        int[][] copied2 = deepCopy();
        right(row, col, copied2);
        down(row, col, copied2);
        if (count0(copied2) < min) {
            direction = 2;
        }
        int[][] copied3 = deepCopy();
        down(row, col, copied3);
        left(row, col, copied3);
        if (count0(copied3) < min) {
            direction = 3;
        }
        int[][] copied4 = deepCopy();
        left(row, col, copied4);
        up(row, col, copied4);
        if (count0(copied4) < min) {
            direction = 4;
        }
        switch (direction) {
            case 1:
                room = copied1;
            case 2:
                room = copied2;
            case 3:
                room = copied3;
            case 4:
                room = copied4;
        }
    }

    static void cctv4(int row, int col) {
        int min = N * M;
        int direction = 0; // 1:no down, 2:no left, 3:no up, 4:no right
        int[][] copied1 = deepCopy();
        left(row, col, copied1);
        up(row, col, copied1);
        right(row, col, copied1);
        if (count0(copied1) < min) {
            direction = 1;
        }
        int[][] copied2 = deepCopy();
        up(row, col, copied2);
        right(row, col, copied2);
        down(row, col, copied2);
        if (count0(copied2) < min) {
            direction = 2;
        }
        int[][] copied3 = deepCopy();
        right(row, col, copied3);
        down(row, col, copied3);
        left(row, col, copied3);
        if (count0(copied3) < min) {
            direction = 3;
        }
        int[][] copied4 = deepCopy();
        down(row, col, copied4);
        left(row, col, copied4);
        up(row, col, copied4);
        if (count0(copied4) < min) {
            direction = 4;
        }
        switch (direction) {
            case 1:
                room = copied1;
            case 2:
                room = copied2;
            case 3:
                room = copied3;
            case 4:
                room = copied4;
        }
    }

    static void cctv5(int row, int col) {
        up(row, col, room);
        right(row, col, room);
        down(row, col, room);
        left(row, col, room);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 사무실의 세로 크기
        M = sc.nextInt(); // 사무실의 가로 크기
        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = sc.nextInt();
            }
        }
        sc.close();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] == 1) {
                    cctv1(i, j);
                } else if (room[i][j] == 2) {
                    cctv2(i, j);
                } else if (room[i][j] == 3) {
                    cctv3(i, j);
                } else if (room[i][j] == 4) {
                    cctv4(i, j);
                } else if (room[i][j] == 5) {
                    cctv5(i, j);
                } else {
                }
            }
        }
        System.out.println(count0(room));
    }
}
