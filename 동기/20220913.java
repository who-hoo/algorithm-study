import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Solution s = new Solution();
        System.out.println(s.solution(n, r, c));
    }

    public int solution(int n, int r, int c) {
        n = (int) Math.pow(2, n);
        search(n, r, c);
        return answer;
    }

    public void search(int n, int r, int c) {
        if (n == 1) {
            return;
        }

        int size = n / 2;
        // r, c가 size보다 작은 경우
        if (r < size && c < size) {
            search(size, r, c);
        } else if (c >= size && r < size) {
            answer += n * n / 4;
            search(size, r, c - size);
        } else if (r >= size && c < size) {
            answer += n * n / 2;
            search(size, r - size, c);
        } else {
            // r, c 둘 다 사이즈보다 클 경우
            answer += n * n / 4 * 3;
            search(size, r - size, c - size);
        }
    }
}
