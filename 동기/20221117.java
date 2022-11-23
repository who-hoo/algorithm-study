import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Main s = new Main();
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        System.out.println(s.solution(n, arr, x));
    }

    public int solution(int n, int[] arr, int x) {
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        int count = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == x) {
                count++;
                start++;
                end--;
                continue;
            }

            if (sum < x) {
                start++;
            } else if (sum > x) {
                end--;
            }
        }

        return count;
    }
}
