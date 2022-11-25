import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ladders = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladders[a] = b;
        }

        Main s = new Main();
        System.out.println(s.solution(n, m, ladders));
    }

    private int solution(int n, int m, int[] ladders) {
        Queue<Integer> q = new LinkedList<>();
        int[] count = new int[101];
        boolean[] visited = new boolean[101];
        q.offer(1);

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == 100) {
                return count[current];
            }

            for (int i = 1; i < 7; i++) {
                int now = current + i;
                if (now > 100) {
                    continue;
                }

                if (visited[now]) {
                    continue;
                }

                visited[now] = true;
                if (ladders[now] != 0) {
                    // 사다리를 타야할 때
                    if (!visited[ladders[now]]) {
                        visited[ladders[now]] = true;
                        count[ladders[now]] = count[current] + 1;
                        q.offer(ladders[now]);
                    }
                } else {
                    // 그냥
                    q.offer(now);
                    count[now] = count[current] + 1;
                }
            }
        }
        return 0;
    }

}
