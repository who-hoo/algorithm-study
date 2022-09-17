import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n;
    public static int r;
    public static int c;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);
        
        if (r == 0 && c == 0) {
            System.out.println(0);
            return;
        }

        double pow = Math.pow(2, n);
        iterateZ(0, 0, (int) pow / 2);
    }

    public static void iterateZ(int startY, int startX, int length) {
        if (length == 1) {
            int[] dy = {0, 0, 1, 1};
            int[] dx = {0, 1, 0, 1};
            for (int i = 0; i < 4; i++) {
                count++;
                int nextY = startY + dy[i];
                int nextX = startX + dx[i];
                if (nextY == r && nextX == c) {
                    System.out.println(count - 1);
                    return;
                }
            }
        }

        int[] dy = {0, 0, length, length};
        int[] dx = {0, length, 0, length};
        for (int i = 0; i < 4; i++) {
            int nextY = startY + dy[i];
            int nextX = startX + dx[i];

            if ((nextY <= r && r < nextY + length) && (nextX <= c && c < nextX + length)) {
                count += Math.pow(length, 2) * i;
                iterateZ(nextY, nextX, length / 2);
            }
        }
    }
}
