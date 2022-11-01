import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] map = new long[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + Long.parseLong(line.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(line.nextToken());
            int y1 = Integer.parseInt(line.nextToken());
            int x2 = Integer.parseInt(line.nextToken());
            int y2 = Integer.parseInt(line.nextToken());

            long result = map[x2][y2] - map[x1 - 1][y2] - map[x2][y1 - 1] + map[x1 - 1][y1 - 1];

            System.out.println(result);
        }
    }

}
