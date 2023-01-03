import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Main s = new Main();
        System.out.println(s.solution(n, arr));
    }

    public int solution(int n, int[] arr) {
        boolean[] prime = new boolean[n + 1];
        int answer = 0;
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!prime[i]) {
                answer += arr[i];
            }
        }

        return answer;
    }
}

