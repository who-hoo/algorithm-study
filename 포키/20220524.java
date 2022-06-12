import java.util.Scanner;

public class BOJ2468 {

    static int[] rowDirection = {0, -1, 0, 1};
    static int[] columnDirection = {-1, 0, 1, 0};
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new int[n][n];


        int currentWaterHeight = 0;
        int maxWaterHeight = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if (maxWaterHeight < graph[i][j]) maxWaterHeight = graph[i][j];
            }
        }

        int answer = 1;

        while (currentWaterHeight <= maxWaterHeight) {
            visited = new boolean[n][n];
            int count = 0;


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] <= currentWaterHeight) {
                        visited[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && graph[i][j] > currentWaterHeight) {
                        count += dfs(currentWaterHeight, i, j);
                    }
                }
            }
            answer = Math.max(answer, count);
            currentWaterHeight++;
        }

        System.out.println(answer);

    }

    public static int dfs(int waterHeight, int row, int column) {
        visited[row][column] = true;

        //4가지 방향 검사
        //상,좌,하,우z
        for (int i = 0; i < 4; i++) {
            int nextRow = row + rowDirection[i];
            int nextColumn = column + columnDirection[i];

            //이동할 위치가 맵을 벗어나면 무시하기
            if (nextRow < 0 || nextColumn < 0 || nextRow >= graph.length || nextColumn >= graph.length) {
                continue;
            }

            if (!visited[nextRow][nextColumn] && graph[nextRow][nextColumn] > waterHeight) {
                dfs(waterHeight, nextRow, nextColumn);
            }
        }

        return 1;
    }
}
