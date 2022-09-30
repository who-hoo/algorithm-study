import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()),
            k = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        int[] fishes = new int[n];

        for (int i = 0; i < n; i++) {
            fishes[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        Set<Integer> pick = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < i + k; j++) {
                pick.add(fishes[j % n]);
            }

            pick.add(c);

            int count = pick.size();
            result = Math.max(result, count);
            if (d == count) {
                break;
            }

            pick.clear();
        }

        print(result);

        bw.flush();
        bw.close();
    }

    private static void print(long value) throws IOException {
        bw.write(String.valueOf(value));
        bw.write("\n");
    }
}
