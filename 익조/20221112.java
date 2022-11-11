import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[][] city;
    static List<int[]> housePositions = new ArrayList<>();
    static List<int[]> chickenHousesPositions = new ArrayList<>();
    static int chickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2) {
                    chickenHousesPositions.add(new int[]{i, j});
                } else if (city[i][j] == 1) {
                    housePositions.add(new int[]{i, j});
                }
            }
        }

        boolean[] broken = new boolean[chickenHousesPositions.size()];
        breakChickenHouse(0, 0, chickenHousesPositions.size() - m, broken);

        bw.write(String.valueOf(chickenDistance));

        bw.flush();
        bw.close();
    }

    private static void breakChickenHouse(int depth, int countOfBreak, int target,
        boolean[] broken) {
        if (countOfBreak == target) {
            chickenDistance = Math.min(chickenDistance, getChickenDistance(broken));
            return;
        }

        if (depth == broken.length) {
            return;
        }

        broken[depth] = true;
        int[] pos = chickenHousesPositions.get(depth);
        city[pos[0]][pos[1]] = 0;
        breakChickenHouse(depth + 1, countOfBreak + 1, target, broken);

        city[pos[0]][pos[1]] = 2;
        broken[depth] = false;
        breakChickenHouse(depth + 1, countOfBreak, target, broken);
    }

    private static int getChickenDistance(boolean[] broken) {
        int sum = 0;

        for (int[] housePosition : housePositions) {
            int distance = Integer.MAX_VALUE;
            for (int i = 0; i < chickenHousesPositions.size(); i++) {
                if (!broken[i]) {
                    int[] chickenHousesPosition = chickenHousesPositions.get(i);
                    distance = Math.min(distance,
                        Math.abs(housePosition[0] - chickenHousesPosition[0]) + Math.abs(
                            housePosition[1] - chickenHousesPosition[1])
                    );
                }
            }
            sum += distance;
        }

        return sum;
    }
}
