import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int output = Integer.parseInt(st.nextToken());

            String[] numbers = new String[10000];
            boolean[] visited = new boolean[10000];

            Queue<Integer> queue = new LinkedList<>();

            visited[input] = true;
            queue.add(input);
            Arrays.fill(numbers, "");
            while (!queue.isEmpty() && !visited[output]) {

                int now = queue.poll();

                int D = (2 * now) % 10000;
                int S = (now == 0) ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                if (!visited[D]) {
                    queue.add(D);
                    visited[D] = true;
                    numbers[D] = numbers[now] + "D";
                }

                if (!visited[S]) {
                    queue.add(S);
                    visited[S] = true;
                    numbers[S] = numbers[now] + "S";
                }
                if (!visited[L]) {
                    queue.add(L);
                    visited[L] = true;
                    numbers[L] = numbers[now] + "L";
                }
                if (!visited[R]) {
                    queue.add(R);
                    visited[R] = true;
                    numbers[R] = numbers[now] + "R";
                }
            }
            System.out.println(numbers[output]);
        }

    }
}
