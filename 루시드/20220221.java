package AlgorithmStudy.boj1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        cost[0][0] = Integer.parseInt(st.nextToken());
        cost[0][1] = Integer.parseInt(st.nextToken());
        cost[0][2] = Integer.parseInt(st.nextToken());

        int idx = 1;
        int count = N - 1;
        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());
            cost[idx][0] = Integer.parseInt(st.nextToken()) + Math.min(cost[idx - 1][1], cost[idx - 1][2]);
            cost[idx][1] = Integer.parseInt(st.nextToken()) + Math.min(cost[idx - 1][0], cost[idx - 1][2]);
            cost[idx][2] = Integer.parseInt(st.nextToken()) + Math.min(cost[idx - 1][0], cost[idx - 1][1]);
            idx++;
        }
        System.out.println(Math.min(Math.min(cost[N - 1][0], cost[N - 1][1]), cost[N - 1][2]));
    }
}
