package AlgorithmStudy.boj15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] result;
    static int[][] arr;
    static List<CCTV> cctvs = new ArrayList<>();

    static int N, M;
    static int answer = Integer.MAX_VALUE;

    // 북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] value = br.readLine().split(" ");
        N = Integer.parseInt(value[0]);
        M = Integer.parseInt(value[1]);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
                if (arr[i][j] != 0 && arr[i][j] != 6) {
                    cctvs.add(new CCTV(arr[i][j], i, j));
                }
            }
        }
        result = new int[cctvs.size()];
        permu(0, cctvs.size());
        System.out.println(answer);
    }

    public static void permu(int depth, int r) {
        if (depth == r) {
            int[][] tmpBoard = new int[arr.length][arr[0].length];
            for (int i = 0; i < arr.length; i++) {
                System.arraycopy(arr[i], 0, tmpBoard[i], 0, tmpBoard[i].length);
            }

            for (int i = 0; i < r; i++) {
                updateBoard(result[i], cctvs.get(i), tmpBoard);
            }

            int blindSpot = 0;
            for (int[] ints : tmpBoard) {
                for (int anInt : ints) {
                    if (anInt == 0) {
                        blindSpot++;
                    }
                }
            }
            answer = Math.min(answer, blindSpot);
            return;
        }

        for (int i = 0; i < 4; i++) {
            result[depth] = i;
            permu(depth + 1, r);
        }
    }

    private static void updateBoard(int direction, CCTV cctv, int[][] tmpBoard) {
        if (cctv.value == 1) {
            monitor(direction, cctv, tmpBoard);
        }
        if (cctv.value == 2) {
            // 가로 방향(<->)
            if (direction == 0 || direction == 2) {
                monitor(1, cctv, tmpBoard);
                monitor(3, cctv, tmpBoard);
                return;
            }
            // 세로 방향
            if (direction == 1 || direction == 3) {
                monitor(0, cctv, tmpBoard);
                monitor(2, cctv, tmpBoard);
                return;
            }
        }
        if (cctv.value == 3) {
            // 동북
            if (direction == 0) {
                monitor(1, cctv, tmpBoard);
                monitor(0, cctv, tmpBoard);
                return;
            }
            // 서북
            if (direction == 1) {
                monitor(3, cctv, tmpBoard);
                monitor(0, cctv, tmpBoard);
                return;
            }
            // 남서
            if (direction == 2) {
                monitor(2, cctv, tmpBoard);
                monitor(3, cctv, tmpBoard);
                return;
            }
            // 남동
            monitor(2, cctv, tmpBoard);
            monitor(1, cctv, tmpBoard);
            return;
        }

        if (cctv.value == 4) {
            // 동서북
            if (direction == 0) {
                monitor(1, cctv, tmpBoard);
                monitor(3, cctv, tmpBoard);
                monitor(0, cctv, tmpBoard);
                return;
            }
            // 서남북
            if (direction == 1) {
                monitor(2, cctv, tmpBoard);
                monitor(3, cctv, tmpBoard);
                monitor(0, cctv, tmpBoard);
                return;
            }
            // 동서남
            if (direction == 2) {
                monitor(1, cctv, tmpBoard);
                monitor(3, cctv, tmpBoard);
                monitor(2, cctv, tmpBoard);
                return;
            }
            // 동북남
            monitor(1, cctv, tmpBoard);
            monitor(0, cctv, tmpBoard);
            monitor(2, cctv, tmpBoard);
            return;
        }
        if (cctv.value == 5) {
            monitor(0, cctv, tmpBoard);
            monitor(1, cctv, tmpBoard);
            monitor(2, cctv, tmpBoard);
            monitor(3, cctv, tmpBoard);
        }
    }

    public static void monitor(int direction, CCTV cctv, int[][] tmpBoard) {
        while (true) {
            int nx = cctv.x + dx[direction];
            int ny = cctv.y + dy[direction];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (tmpBoard[nx][ny] == 6) {
                    break;
                }
                tmpBoard[nx][ny] = 7;
                cctv.x = nx;
                cctv.y = ny;
                continue;
            }
            break;
        }
    }

    static class CCTV {
        int value;
        int x;
        int y;

        public CCTV(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

}
