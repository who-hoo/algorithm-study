import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        Integer[] prices = new Integer[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        Arrays.sort(prices, Collections.reverseOrder());

        int result = 0;

        for (int price : prices) {
            if (k / price > 0) {
                result += (k / price);
                k %= price;
            }
            if (k == 0) {
                break;
            }
        }

        System.out.println(result);
    }
}
