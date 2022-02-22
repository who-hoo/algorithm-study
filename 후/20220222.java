import java.util.Scanner;

public class Main {

    static final int[][] cost = new int[1001][3];
    static final int[][] memo = new int[1001][3];
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;

    public static void memo(int n) {
        memo[n][R] = Math.min(memo[n - 1][G], memo[n - 1][B]) + cost[n][R];
        memo[n][G] = Math.min(memo[n - 1][R], memo[n - 1][B]) + cost[n][G];
        memo[n][B] = Math.min(memo[n - 1][R], memo[n - 1][G]) + cost[n][B];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            cost[i][R] = sc.nextInt();
            cost[i][G] = sc.nextInt();
            cost[i][B] = sc.nextInt();
        }
        sc.close();

        memo[1][R] = cost[1][R];
        memo[1][G] = cost[1][G];
        memo[1][B] = cost[1][B];
        for (int i = 2; i <= n; i++) {
            memo(i);
        }

        System.out.println(Math.min(Math.min(memo[n][R], memo[n][G]), memo[n][B]));
    }
}
