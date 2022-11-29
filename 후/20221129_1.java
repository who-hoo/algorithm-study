import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Ladder {

        int x;
        int y;

        public Ladder(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // input
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        final int N = Integer.parseInt(tokenizer.nextToken()); // 사다리의 수
        final int M = Integer.parseInt(tokenizer.nextToken()); // 뱀의 수
        final List<Ladder> ladders = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(in.readLine());
            final int x = Integer.parseInt(tokenizer.nextToken());
            final int y = Integer.parseInt(tokenizer.nextToken());
            ladders.add(new Ladder(x, y));
        }
        in.close();
    }
}
