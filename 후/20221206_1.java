import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine()); // 수열 A의 길이

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int e = Integer.parseInt(st.nextToken());
            if (isPrime(i)) {
                answer += e;
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
