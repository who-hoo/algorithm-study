import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); //벨트 위 접시 수
        int d = Integer.parseInt(st.nextToken()); //초밥의 가지 수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> sushiEaten;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            sushiEaten = new HashSet<>();
            for (int j = 0; j < k; j++) {
                if (n <= i + j) {
                    sushiEaten.add(sushi[(i + j) - n]);
                } else {
                    sushiEaten.add(sushi[i + j]);
                }
            }
            sushiEaten.add(c);
            maxCount = Math.max(maxCount, sushiEaten.size());
        }

        System.out.println(maxCount);
    }
}
