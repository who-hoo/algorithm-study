import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, m, b;
    static int[][] map;

    static class Result {
        int time;
        int height;

        Result(int time, int height) {
            this.time = time;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        b = Integer.parseInt(st1.nextToken());

        map = new int[n][m];

        StringTokenizer st2;

        for (int i = 0; i < n; i++) {
            st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int min = 257;
        int max = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min = min > map[i][j] ? map[i][j] : min;
                max = map[i][j] > max ? map[i][j] : max;
            }
        }

        double result_time = Double.POSITIVE_INFINITY;
        int result_height = 0;

        for (int i = min; i < max + 1; i++) {
            Result result = operate(i);
            if (result != null) {
                result_time = result_time > result.time ? result.time : result_time;
                if (result_time == result.time) {
                    result_height = i > result_height ? i : result_height;
                }
            }
        }

        System.out.printf("%d %d", (int) result_time, result_height);
    }

    public static Result operate(int target) {
        int time = 0;
        int inventory = b;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (target > map[i][j]) {
                    inventory -= target - map[i][j];
                    time += target - map[i][j];
                }
                if (target < map[i][j]) {
                    time += 2*(map[i][j] - target);
                    inventory += map[i][j] - target;
                }
            }
        }
        if (inventory < 0) {
            return null;
        }

        return new Result(time, target);
    }
}
