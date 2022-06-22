import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n;
    static boolean[] computers;
    static int[][] network;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        computers = new boolean[n + 1];
        network = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            network[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        spread(1);

        int result = 0;
        for (int i = 2; i < n + 1; i++) {
            if (computers[i]) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static void spread(int start) {
        if (!computers[start]) {
            computers[start] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            if (network[start][i] == 1 && !visited[start][i]) {
                visited[start][i] = true;
                spread(i);
            }
            if (network[i][start] == 1 && !visited[i][start]) {
                visited[i][start] = true;
                spread(i);
            }
        }
    }
}
