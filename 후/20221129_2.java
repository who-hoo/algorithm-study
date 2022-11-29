import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // input
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(in.readLine()); // 수의 개수
        final int[] numbers = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(in.readLine());
        final int plusCount = Integer.parseInt(tokenizer.nextToken());
        final int minusCount = Integer.parseInt(tokenizer.nextToken());
        final int multiplyCount = Integer.parseInt(tokenizer.nextToken());
        final int divideCount = Integer.parseInt(tokenizer.nextToken());
        in.close();
    }
}
