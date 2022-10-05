import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //벨트에 놓인 접시의 수
        int n = Integer.parseInt(st.nextToken());
        //초밥의 가짓수
        int d = Integer.parseInt(st.nextToken());
        //할인혜택
        int k = Integer.parseInt(st.nextToken());
        //쿠폰번호
        int c = Integer.parseInt(st.nextToken());

        List<Integer> sushi = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sushi.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;

        for (int i = 0; i < sushi.size(); i++) {
            int count = 0;
            int[] arr = new int[3001];
            for (int j = 0; j < k; j++) {
                if (arr[sushi.get((i + j) % n)] == 0) {
                    count++;
                }
                arr[sushi.get((i + j) % n)]++;
            }
            if (arr[c] == 0) {
                count++;
            }

            result = Math.max(count, result);
        }

        System.out.println(result);
    }

}
