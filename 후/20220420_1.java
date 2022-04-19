import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * (최적화) M미터를 구할 수 있는 절단기의 최대 높이 (결정) 절단기가 h일 때 절단된 나무가 M미터 이상인가 아닌가
 */
public class Main {

    static long n, m;
    static ArrayList<Long> trees;

    static long binarySearch(long start, long end) {
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (determination(mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    static boolean determination(long h) {
        long sum = trees.stream().filter(t -> t > h)
            .map(t -> t - h)
            .mapToLong(Long::longValue)
            .sum();
        return sum >= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken()); // 나무의 수
        m = Long.parseLong(st.nextToken()); // 집으로 가져가려는 나무의 길이

        st = new StringTokenizer(br.readLine());
        trees = new ArrayList<>((int) n);
        for (long i = 0; i < n; i++) {
            Long tree = Long.valueOf(st.nextToken());
            trees.add(tree);
        }
        br.close();

        Collections.sort(trees);
        System.out.println(binarySearch(0, trees.get((int) (n - 1))));
    }
}
