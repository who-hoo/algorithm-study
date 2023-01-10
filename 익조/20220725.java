import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static int n, size;
    static double result = 0.0;
    static Map<String, Double> percentagesByDirection = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        // 동, 서, 남, 북
        String[] directions = {"EAST", "WEST", "SOUTH", "NORTH"};
        int percentage;
        for (String direction : directions) {
            percentage = Integer.parseInt(st.nextToken());
            if (percentage != 0) {
                percentagesByDirection.put(direction, percentage * 0.01);
            }
        }

        size = n * 2 + 1;

        boolean[][] visited = new boolean[size][size];
        visited[n][n] = true;
        move(n, n + 1, 1, 1.0, visited, "EAST");

        visited = new boolean[size][size];
        visited[n][n] = true;
        move(n, n - 1, 1, 1.0, visited, "WEST");

        visited = new boolean[size][size];
        visited[n][n] = true;
        move(n + 1, n, 1, 1.0, visited, "SOUTH");

        visited = new boolean[size][size];
        visited[n][n] = true;
        move(n - 1, n, 1, 1.0, visited, "NORTH");

        System.out.println(result);
    }

    public static void move(int x, int y, int depth, double percent, boolean[][] visited, String direction) {
        if (x < 0 || x > size - 1 || y < 0 || y > size -1 || !percentagesByDirection.containsKey(direction) || visited[x][y]) {
            return;
        }

        percent *= percentagesByDirection.get(direction) * 1000000000 / 1000000000.0;

        if (depth == n) {
            result += percent;
            return;
        }

        visited[x][y] = true;
        depth++;

        move(x + 1, y, depth, percent, visited, "SOUTH");
        move( x - 1, y, depth, percent, visited, "NORTH");
        move( x, y + 1, depth, percent, visited, "EAST");
        move( x, y - 1, depth, percent, visited, "WEST");

        visited[x][y] = false;
    }
}
