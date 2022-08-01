import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[2][n];

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
    }

}
