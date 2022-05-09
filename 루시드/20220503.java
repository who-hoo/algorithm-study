import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] tomatos;
    static int anIk = 0;
    static Queue<Pos> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        int H = Integer.parseInt(s[2]);

        tomatos = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] tmp = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    tomatos[i][j][k] = Integer.parseInt(tmp[k]);
                    if (tomatos[i][j][k] == 0) {
                        anIk++;
                    }
                    if (tomatos[i][j][k] == 1) {
                        queue.add(new Pos(j, k, i));
                    }
                }
            }
        }
        if (anIk == 0) {
            System.out.println(0);
            return;
        }

        int day = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            day++;
            for (int k = 0; k < size; k++) {
                Pos curPos = queue.poll();
                for (int i = 0; i < 6; i++) {
                    int nx = curPos.x + dx[i];
                    int ny = curPos.y + dy[i];
                    int nz = curPos.z + dz[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H || tomatos[nz][nx][ny] == 1
                        || tomatos[nz][nx][ny] == -1) {
                        continue;
                    }
                    tomatos[nz][nx][ny] = 1;
                    queue.add(new Pos(nx, ny, nz));
                    anIk--;
                }
                if (anIk == 0) {
                    System.out.println(day);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    static class Pos {
        int x;
        int y;
        int z;

        public Pos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
