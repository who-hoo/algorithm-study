import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    boolean[][] visited;
    int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // n * n 맵
        int m = Integer.parseInt(split[1]); // 살릴 치킨집 갯수
        String[][] map = new String[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }

        Main s = new Main();
        System.out.println(s.solution(n, m, map));
    }

    public int solution(int n, int m, String[][] map) {
        visited = new boolean[n][n];
        List<int[]> houses = new ArrayList<>();
        List<int[]> chickens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 집 좌표
                if (map[i][j].equals("1")) {
                    houses.add(new int[]{i, j});
                    // 치킨집 좌표
                } else if (map[i][j].equals("2")) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        // 도시의 치킨 거리 최소값 반환
        // 도시의 치킨 거리는 모든 집의 치킨 거리의 합
        // 각각의 집은 치킨 거리를 가지고 있다
        // 치킨 거리란 집과 가장 가까운 치킨집 사이의 거리

        // 집마다 치킨 거리를 구한다
        // 치킨 거리를 더해서 도시의 치킨 거리를 구한다
        // 치킨집을 폐쇄해야하는 상황이면 치킨집을 하나 삭제한다 -> 이걸 어떻게 구현하지
        // 집마다 치킨 거리를 구한다
        // 반복 ~
        for (int[] house : houses) {
            int x = house[0];
            int y = house[1];
            dfs(x, y);
        }

        return min;
    }

    public void dfs(int x, int y) {
        
    }

}
