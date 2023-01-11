import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static List<List<Integer>> network = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            network.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            network.get(start).add(end);
            network.get(end).add(start);
        }

        boolean[] visited = new boolean[n + 1];
        spread(1, visited);

        System.out.println(result);
    }

    private static void spread(int start, boolean[] visited) {
        visited[start] = true;

        for (int i = 0; i < network.get(start).size(); i++) {
            int end = network.get(start).get(i);
            if (!visited[end]) {
                result++;
                spread(end, visited);
            }
        }
    }
}
