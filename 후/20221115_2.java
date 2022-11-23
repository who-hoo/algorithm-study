import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);
        final int[][] map = new int[N][N];
        for (int row = 0; row < N; row++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        in.close();
    }
}
