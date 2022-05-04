import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Main {

    static int n, m, h;
    static List<int[][]> house = new ArrayList<>();
    static List<boolean[][]> visitedHouse = new ArrayList<>();
    static Queue<Tomato> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0, 0, 0}, dy = {0, 0, 1, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};
    static int result = 0;

    static class Tomato {

        int x;
        int y;
        int z;
        int day;

        public Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        for (int i = 0; i < h; i++) {
            int[][] tomatoes = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    tomatoes[j][k] = sc.nextInt();
                }
            }
            house.add(tomatoes);

            boolean[][] visited = new boolean[n][m];
            visitedHouse.add(visited);
        }

        boolean flag = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (house.get(i)[j][k] == 0) {
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (flag) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (house.get(i)[j][k] == 1) {
                        queue.add(new Tomato(j, k, i, 0));
                        visitedHouse.get(i)[j][k] = true;
                    }
                }
            }
        }

        bfs();

        System.out.println(result);
    }

    public static void bfs() {
        int nx, ny, nz;

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            result = tomato.day > result ? tomato.day : result;
            for (int k = 0; k < 6; k++) {
                nx = tomato.x + dx[k];
                ny = tomato.y + dy[k];
                nz = tomato.z + dz[k];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1 || nz < 0 || nz > h - 1 || visitedHouse.get(nz)[nx][ny]
                    || house.get(nz)[nx][ny] == -1) {
                    continue;
                }

                visitedHouse.get(nz)[nx][ny] = true;

                if (house.get(nz)[nx][ny] == 0) {
                    house.get(nz)[nx][ny] = 1;
                    queue.add(new Tomato(nx, ny, nz,tomato.day + 1));
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (house.get(i)[j][k] == 0) {
                        result = -1;
                        break;
                    }
                }
            }
        }
    }
}
