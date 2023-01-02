import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);

        int p1 = 0, p2 = n - 1, result = 0;
        while (p1 < p2) {
            if (numbers[p1] + numbers[p2] == x) {
                result++;
                p1++;
                p2--;
            } else if (numbers[p1] + numbers[p2] < x) {
                p1++;
            } else {
                p2--;
            }
        }

        System.out.println(result);
    }
}
