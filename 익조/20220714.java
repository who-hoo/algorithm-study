import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int result = 1000, n;
    static int[][] abilities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        abilities = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[n + 1];
        select(visited, 1, 0);

        System.out.println(result);
    }

    private static void select(boolean[] visited, int depth, int count) {
        if (count == n / 2) {
            verify(visited);
            return;
        }

        if (depth == n + 1) {
            return;
        }

        visited[depth] = true;
        select(visited, depth + 1, count + 1);
        visited[depth] = false;
        select(visited, depth + 1, count);
    }

    private static void verify(boolean[] visited) {
        List<Integer> start = new ArrayList<>();
        List<Integer> link = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                start.add(i);
            } else {
                link.add(i);
            }
        }

        int startAbility = 0, linkAbility = 0, half = n / 2;

        int x, y, z, w;
        for (int i = 0; i < half ; i++) {
            for (int j = i + 1; j < half; j++) {
                x = start.get(i);
                y = start.get(j);
                z = link.get(i);
                w = link.get(j);
                startAbility += abilities[x][y] + abilities[y][x];
                linkAbility += abilities[z][w] + abilities[w][z];
            }
        }

        result = Math.min(result, Math.abs(startAbility - linkAbility));
    }
}
