import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            coins.add(sc.nextInt());
        }

        for (int i = coins.size() - 1; i >= 0; i--) {
            if (coins.get(i) <= k) {
                int coin = coins.get(i);
                result += k / coin;
                k = k % coin;
            }
        }
        System.out.println(result);
    }
}

//각 동전을 돌면서 n을 나누기
//4790
//4790 : 1000 - 4
//790 : 500 - 1
//290 : 100 - 2
//90 : 50 - 1
//40 : 10 -4
