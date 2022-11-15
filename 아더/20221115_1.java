import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M, ANSWER;
    static boolean[] selected;
    static int[][] city;
    static List<Coordinate> houses, chickens;

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        rec_func(0, 1);

        System.out.println(ANSWER);
    }

    private static void rec_func(int currentM, int start) {
        if (currentM == M) {
            int chickenDistance = 0;
            for (Coordinate house : houses) {
                int eachChickenDistance = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (selected[i + 1]) {
                        Coordinate chicken = chickens.get(i);
                        eachChickenDistance = Math.min(eachChickenDistance, calculateChickenDistance(house.x, house.y, chicken.x, chicken.y));
                    }
                }
                chickenDistance += eachChickenDistance;
            }

            ANSWER = Math.min(ANSWER, chickenDistance);
            return;
        } else if (currentM < M) {
            for (int i = start; i <= chickens.size(); i++) {
                selected[i] = true;
                rec_func(currentM + 1, start + 1);
                selected[i] = false;
            }
        }
    }

    private static int calculateChickenDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        ANSWER = Integer.MAX_VALUE;
        city = new int[N + 1][N + 1];
        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            split = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                int type = Integer.parseInt(split[j - 1]);
                city[i][j] = type;
                if (type == 2) {
                    chickens.add(new Coordinate(i, j));
                } else if (type == 1) {
                    houses.add(new Coordinate(i, j));
                }
            }
        }

        selected = new boolean[chickens.size() + 1];
    }
}
