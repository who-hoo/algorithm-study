import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int days;
    static int[] prices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            days = Integer.parseInt(br.readLine());
            prices = new int[days];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < days; j++) {
                prices[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(trade() + "\n");
        }
        bw.close();
    }

    public static long trade() {
        long result = 0;
        int max = 0;

        for (int j = days - 1; j >= 0; j--) {
            if (prices[j] > max) {
                max = prices[j];
            }
            else {
                result += max - prices[j];
            }
        }

        return result;
    }
}
