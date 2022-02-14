import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] memo = new int[301];

        int[] steps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            steps[i] = Integer.parseInt(sc.nextLine());
        }

        memo[1] = steps[1];
        if (n >= 2)
            memo[2] = steps[2] + steps[1];
        if (n >= 3)
            memo[3] = getMaxValue(steps[3] + steps[2], steps[3] + steps[1]);

        for (int i = 4; i <= n; i++) {
            memo[i] = getMaxValue(steps[i] + steps[i - 1] + memo[i - 3], steps[i] + memo[i - 2]);
        }

        System.out.println(memo[n]);
    }

    public static int getMaxValue(int a, int b) {
        return a >= b ? a : b;
    }

}
