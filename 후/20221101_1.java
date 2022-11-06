import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        final int N = Integer.parseInt(tokenizer.nextToken());
        final int M = Integer.parseInt(tokenizer.nextToken());
        final int[][] paper = new int[N][M];
        for (int row = 0; row < N; row++) {
            tokenizer = new StringTokenizer(in.readLine());
            for (int col = 0; col < M; col++) {
                paper[row][col] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        in.close();
    }
}
