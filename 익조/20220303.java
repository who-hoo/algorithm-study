import java.util.Scanner;

class Main {

    static int n;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n+1; i++) { // 기준 노드
            for (int j = 1; j < n+1; j++) { // 연결 노드
                if (graph[i][j] == 1) {
                    find(i, j);
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                System.out.printf("%d ", graph[i][j]);
            }
            System.out.println();
        }
    }

    public static void find(int x, int y) {
        if (visited[x][y] == true) return;

        visited[x][y] = true;

        for (int i = 1; i < n+1; i++) {
            if (graph[y][i] == 1) {
                graph[x][i] = 1;
                find(x, i);
            }
        }
    }
}
