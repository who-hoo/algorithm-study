import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] lottoResult = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int replyCount = Integer.parseInt(st.nextToken());
            if (replyCount == 0) {
                break;
            }
            int[] lotto = new int[replyCount];
            for (int i = 0; i < replyCount; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            comb(lotto, 0, 0);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void comb(int[] lotto, int now, int firstValue) {
        if (now == 6) {
            for (int value : lottoResult) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = firstValue; i < lotto.length; i++) {
            lottoResult[now] = lotto[i];
            comb(lotto, now + 1, i + 1);
        }

    }
}
