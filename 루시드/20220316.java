import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N, maxValue, cur;
        long sum;
        int[] stockPriceInfo;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            stockPriceInfo = new int[N];
            String[] price = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                stockPriceInfo[i] = Integer.parseInt(price[i]);
            }

            maxValue = stockPriceInfo[N - 1];
            sum = 0;
            for (int i = N - 2; i >= 0; i--) {
                cur = stockPriceInfo[i];
                if (cur <= maxValue) {
                    sum += maxValue - cur;
                    continue;
                }
                maxValue = cur;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
