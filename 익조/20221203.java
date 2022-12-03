import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] prime = new boolean[n + 1]; // 최초 0 ~ n 까지의 모든 수가 소수(false)라고 가정한다.
        prime[0] = prime[1] = true; // 0과 1은 소수가 아니다.
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) { // i가 소수인 경우
                for (int j = i * i ; j <= n; j += i) { // i 자기 자신을 제외한 i의 배수의 수는 소수가 아니다. 
                    prime[j] = true;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!prime[i]) {
                result += numbers[i];
            }
        }
        System.out.println(result);
    }
}
