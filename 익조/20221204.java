import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 0; i < n; i++) {
            if (memo[i] == Integer.MAX_VALUE) continue;
            char prev = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char pres = s.charAt(j);
                if (prev == 'B' && pres == 'O' ||
                    prev == 'O' && pres == 'J' ||
                    prev == 'J' && pres == 'B') {
                    memo[j] = Math.min(memo[j], memo[i] + (j - i) * (j - i));
                }
            }
        }

        System.out.println(memo[n - 1] == Integer.MAX_VALUE ? -1 : memo[n - 1]);
    }
}
