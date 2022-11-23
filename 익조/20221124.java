import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snakes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            snakes.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        boolean[] visited = new boolean[101];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        Loop : while (!queue.isEmpty()) {

            int[] pos = queue.poll();

            for (int i = 1; i < 7; i++) {
                if (pos[0] + i >= 100) {
                    System.out.println(pos[1] + 1);
                    break Loop;
                }

                if (visited[pos[0] + i]) {
                    continue;
                }

                visited[pos[0] + i] = true;

                if (ladder.containsKey(pos[0] + i)) {
                    queue.add(new int[]{ladder.get(pos[0] + i), pos[1] + 1});
                } else if (snakes.containsKey(pos[0] + i)) {
                    queue.add(new int[]{snakes.get(pos[0] + i), pos[1] + 1});
                } else {
                    queue.add(new int[]{pos[0] + i, pos[1] + 1});
                }
            }
        }
    }
}
