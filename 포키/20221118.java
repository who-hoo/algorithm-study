import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n - 1;
        int count = 0;

        while (start < end) {
            int result = numbers[start] + numbers[end];

            if (result == x) {
                start++;
                end--;
                count++;
            } else if (result < x) {
                start++;
            }else{
                end--;
            }
        }
        System.out.println(count);
    }
}
