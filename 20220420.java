import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int[] coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        int cur;
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) {
                break;
            }
            cur = coin[i];
            if (K >= cur) {
                count += (K / cur);
            }
            K %= cur;
        }
        System.out.println(count);
    }
}
