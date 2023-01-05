import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {

    static int n, countOfHouses = 0;
    static int[][] graph;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int countOfComplex = 0;
        List<Integer> houses = new ArrayList<>();
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    countOfComplex++;
                    houses.add(countOfHouses);
                    countOfHouses = 0;
                }
            }
        }

        Collections.sort(houses);

        System.out.println(countOfComplex);
        for (Integer house : houses) {
            System.out.println(house);
        }
    }

    private static void dfs(int x, int y) {
        if (x < 0 || x > n - 1 || y < 0 || y > n - 1 || visited[x][y] || graph[x][y] == 0) {
            return;
        }

        visited[x][y] = true;
        countOfHouses++;

        dfs(x - 1, y);
        dfs( x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }

}
