import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static List<ArrayList<City>> cities;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 도시의 개수
        m = Integer.parseInt(br.readLine());    // 버스의 개수
        cities = new ArrayList<>();
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);

        for (int i = 0; i <= n; i++) {
            cities.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            cities.get(from).add(new City(to, cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<City> q = new PriorityQueue<>();
        dist[start] = 0;
        q.offer(new City(start, 0));

        while (!q.isEmpty()) {
            City pollCity = q.poll();
            int to = pollCity.to;

            if (!visited[to]) {
                visited[to] = true;

                for (City city : cities.get(to)) {
                    if (!visited[city.to] && dist[city.to] > (dist[to] + city.cost)) {
                        dist[city.to] = dist[to] + city.cost;
                        q.offer(new City(city.to, dist[city.to]));
                    }
                }
            }
        }
        return dist[end];
    }
}

class City implements Comparable<City> {

    int to;
    int cost;

    public City(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(City o) {
        return cost - o.cost;
    }
}
