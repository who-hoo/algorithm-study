package beakjoon.greedy;

import java.io.*;

public class Main_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            int quotient = K / coins[i];
            if (quotient > 0) {
                K %= coins[i];
                result += quotient;

                if (K == 0) {
                    System.out.println(result);
                    break;
                }
            }

        }

    }
}
