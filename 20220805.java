import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        long[] arr = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1] + Long.parseLong(st.nextToken());
        }

        int start = 0;
        int end = 1;
        int answer = 100_000;
        while (end < n + 1) {
            if (arr[end] - arr[start] < s) {
                end++;
                continue;
            }
            if (s <= arr[end] - arr[start]) {
                answer = Math.min(answer, end - start);
                start++;
                continue;
            }
        }
        if (answer == 100_000) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }

    }

}
