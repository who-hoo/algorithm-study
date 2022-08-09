import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Main m = new Main();
        System.out.println(m.solution(n, s, arr));
    }


    public int solution(int n, int s, int[] arr) {
        int start = 0;
        int end = 0;
        int total = 0;
        while (start <= n && end <= n) {
            if (total < s) {
                total += arr[end];
                end++;
            } else if (total > s) {
                total -= arr[start];
                start++;
            }
        }
        return -1;
    }
}
