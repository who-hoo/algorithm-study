import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Home> homes = new ArrayList<>();
        List<int[]> chickens = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    homes.add(new Home(i, j));
                } else if (num == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        //각 집들의 치킨거리 저장.
        for (int[] chicken : chickens) {
            int cx = chicken[0];
            int cy = chicken[1];
            for (Home home : homes) {
                int distance = Math.abs(cx - home.x) + Math.abs(cy - home.y);
                if (distance < home.distance) {
                    home.cx = cx;
                    home.cy = cy;
                    home.distance = distance;
                }
            }
        }
        List<Survive> results = new ArrayList<>();
        for (int[] chicken : chickens) {
            int sum = 0;
            int cx = chicken[0];
            int cy = chicken[1];
            for (Home home : homes) {
                sum += Math.abs(home.x - cx) + Math.abs(home.y - cy);
            }
            results.add(new Survive(cx, cy, sum));
        }
        results.sort(Comparator.comparingInt(s -> s.distance));

        Survive[] s = new Survive[m];
        for (int i = 0; i < m; i++) {
            s[i] = results.get(i);
        }

        for (Survive chicken : s) {
            for (Home home : homes) {
                if (home.cx == chicken.x && home.cy == chicken.y) {
                    home.status = true;
                }
            }

        }

        for (int i = 0; i < s.length; i++) {
            Survive chicken = s[i];

            for (Home home : homes) {
                if (!home.status) {
                    if (!(home.cx == chicken.x) || !(home.cy == chicken.y)) {
                        if (i == 0) {
                            home.distance = Integer.MAX_VALUE;
                        }
                        int newDistance =
                            Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
                        if (newDistance <= home.distance) {
                            home.cx = chicken.x;
                            home.cy = chicken.y;
                            home.distance = newDistance;
                        }
                    }

                }
            }
        }

        int sum = 0;
        for (Home home : homes) {
            sum += home.distance;
        }

        System.out.println(sum);

    }

    static class Home {

        int x, y;
        int cx, cy;
        int distance = Integer.MAX_VALUE;
        boolean status = false;

        public Home(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Survive {

        int x, y, distance;

        public Survive(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
