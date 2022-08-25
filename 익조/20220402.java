import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int sizeOfLotto;
    static int[] lottoNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        sizeOfLotto = Integer.parseInt(st.nextToken());

        while (true) {
            lottoNumbers = new int[sizeOfLotto];
            for (int i = 0; i < sizeOfLotto; i++) {
                lottoNumbers[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[sizeOfLotto];
            dfs(visited, 0, 0);

            st = new StringTokenizer(br.readLine());
            sizeOfLotto = Integer.parseInt(st.nextToken());
            if (sizeOfLotto == 0) break;
            else System.out.println();
        }
    }

    public static void dfs(boolean[] visited, int depth, int cnt) {
        if (cnt == 6) {
            print(visited);
            return;
        }

        if (depth == sizeOfLotto) {
            return;
        }

        visited[depth] = true;
        dfs(visited, depth + 1, cnt + 1);
        visited[depth] = false;
        dfs(visited, depth + 1, cnt);
    }

    public static void print(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                System.out.printf("%d ", lottoNumbers[i]);
            }
        }
        System.out.println();
    }
}
