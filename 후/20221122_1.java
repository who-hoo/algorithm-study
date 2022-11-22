import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(in.readLine());
        final int[] numbers = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }
        final int x = Integer.parseInt(in.readLine());
        in.close();

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == x) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
