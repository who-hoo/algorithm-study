import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        Integer[] prices = new Integer[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = n-1; i > -1; i--) {
            if (k / prices[i] > 0) {
                result += (k / prices[i]);
                k %= prices[i];
            }
            if (k == 0) {
                break;
            }
        }

        System.out.println(result);
    }
}
