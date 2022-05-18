import java.util.Scanner;

public class BOJ1238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = i==j ? 0 : 1_000_000;
            }
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int p = sc.nextInt();
            map[s][e] = p;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            int current = map[i][x] + map[x][i];
            result = Math.max(current, result);
        }

        System.out.println(result);
    }
}
