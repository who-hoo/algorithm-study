package beakjoon.main_1405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 미친로봇
* 골드V
* */
public class Main {

    private static int n;
    private static double[] directions = new double[4];
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited = new boolean[29][29];
    private static double result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        for (int i = 0; i < 4; i++) {
            directions[i] = Integer.parseInt(input[i + 1]) * 0.01;
        }
        visited[14][14] = true;
        dfs(14, 14, 1.0);
        System.out.println(result);
    }

    public static void dfs(int x, int y, double probability) {
        if (n == 0) {
            result += probability; //여러 케이스로 성공할 수 있으니 성공할 때마다 계속 더해줌
            return;
        }
        for (int i = 0; i < 4; i++) {
            //dx, dy의 요소를 directions의 동서남북 순서대로 배치하고
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            //동서남북 중 이동할 수 있는 확률이 존재할 때에만 dfs실행
            if (!visited[nextY][nextX] && 0 < directions[i]) {
                n--;
                visited[nextY][nextX] = true;
                dfs(nextX, nextY, probability * directions[i]);
                visited[nextY][nextX] = false;
                n++;
            }
        }
    }
    
}
