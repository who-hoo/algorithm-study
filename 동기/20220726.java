import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int total = 0;
    static int result = Integer.MAX_VALUE;
    static int n;
    static int m;
    static List<City> cities;
    static boolean[] visited;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 도시의 개수
        m = Integer.parseInt(br.readLine());    // 버스의 개수
        cities = new ArrayList<>();
        visited = new boolean[n + 1];

        int[] town = new int[n + 1];
        for (int i = 1; i < town.length; i++) {
            town[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int depart = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            cities.add(new City(depart, arrive, cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dfs(1, 0);
        System.out.println(result);
    }

    private static void dfs(int depart, int arrive) {
        // 탈출 조건
        if (arrive == end) { // 이것이 아닌듯
            result = Math.min(total, result);
            return;
        }

        // 체크할 건 도시 번호고, for문은 버스 경우의 수만큼 돌려야하는데 visited 에서 arrayindexoutofboundsEcefasdfs
        int before = 0;
        for (int i = 0; i < m; i++) {
            City city = cities.get(i);
            if (before != city.depart) { // 조건이 이거면 되는걸까
                visited[i + 1] = true;
                total += city.cost;
                dfs(city.depart, city.arrive);
                visited[i + 1] = false;
            }
        }
    }
}

class City {

    int depart;
    int arrive;
    int cost;

    public City(int depart, int arrive, int cost) {
        this.depart = depart;
        this.arrive = arrive;
        this.cost = cost;
    }
}
