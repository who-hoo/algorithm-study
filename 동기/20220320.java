import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] stocks = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                stocks[j] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            long res = 0;
            for (int j = n - 1; j >= 0; j--) {

                if (max < stocks[j]) {
                    max = stocks[j];
                } else {
                    res += max - stocks[j];
                }
            }
            System.out.println(res);
        }
    }
}
