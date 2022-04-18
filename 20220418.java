import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        long M = Long.parseLong(tmp[1]);

        String[] tree = br.readLine().split(" ");

        long[] height = new long[N];

        for (int i = 0; i < N; i++) {
            height[i] = Long.parseLong(tree[i]);
        }

        long min = 0;
        long max = Arrays.stream(height).max().getAsLong() + 1;
        long mid, sum;

        while (min < max) {
            mid = (min + max) / 2;
            sum = 0;
            for (long l : height) {
                if (l > mid) {
                    sum += (l - mid);
                }
            }
            if (sum >= M) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.println(min - 1);
    }
}
