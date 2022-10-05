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
        int N = Integer.parseInt(st.nextToken()); // 초밥 벨트에 놓인 접시의 수 N
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수 d
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수 k
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 c
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Main s = new Main();
        System.out.println(s.solution(N, d, k, c, arr));
    }

    public int solution(int n, int d, int k, int c, int[] arr) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < k; j++) {
                set.add(arr[(i + j) % n]);
            }
            set.add(c);
            max = Math.max(set.size(), max);
            set.clear();
        }
        return max;
    }
}

