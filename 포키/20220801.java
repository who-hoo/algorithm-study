import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][3];
        int[][] maxMap = new int[n][3];
        int[][] minMap = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(row[0]);
            map[i][1] = Integer.parseInt(row[1]);
            map[i][2] = Integer.parseInt(row[2]);

        }

        for (int i = 0; i < 3; i++) {
            maxMap[0][i] = map[0][i];
            minMap[0][i] = map[0][i];
        }

        for(int i = 1; i <n; i++) {
            maxMap[i][0] += Math.max(maxMap[i - 1][0], maxMap[i - 1][1]) + map[i][0];
            maxMap[i][1] += Math.max(Math.max(maxMap[i - 1][0], maxMap[i - 1][1]), maxMap[i - 1][2]) + map[i][1];
            maxMap[i][2] += Math.max(maxMap[i - 1][1], maxMap[i - 1][2]) + map[i][2];

            minMap[i][0] += Math.min(minMap[i - 1][0], minMap[i - 1][1]) + map[i][0];
            minMap[i][1] += Math.min(Math.min(minMap[i - 1][0], minMap[i - 1][1]), minMap[i - 1][2]) + map[i][1];
            minMap[i][2] += Math.min(minMap[i - 1][1], minMap[i - 1][2]) + map[i][2];
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i < 3; i++) {
            min = Math.min(min, minMap[n-1][i]);
            max = Math.max(max, maxMap[n-1][i]);
        }

        System.out.println(max + " " + min);

    }

}
