import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가지고 있는 동전의 종류
        int K = Integer.parseInt(st.nextToken()); // 만들려는 가치의 합

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int i = N - 1;
        int answer = 0;
        while (i >= 0) {
            answer += (K / coins[i]);
            K %= coins[i];
            i--;
            if (K == 0) {
                break;
            }
        }

        System.out.println(answer);
    }
}
