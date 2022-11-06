import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int N, group_cnt;
    static int[][] adj, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static ArrayList<Integer> group;


    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int x, int y) {
        // 단지에 속한 집의 개수 증가, visit체크
        group_cnt++;
        visit[x][y] = true;
        // 인접한 집으로 새로운 방문하기
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            // 지도를 벗어나는 곳인가
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            // 갈 수 있는 칸인가
            if (adj[nx][ny] == 0) {
                continue;
            }
            // 이미 방문한 적이 있는가
            if (visit[nx][ny]) {
                continue;
            }
            // 재귀호출
            dfs(nx, ny);
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && adj[i][j] == 1) {
                    // 갈 수 있는 칸인데 이미 방문 처리 된 즉 새롭게 만난 단지인 경우
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }
        // 결과 출력
        Collections.sort(group);
        System.out.println(group.size());
        for (int num : group) {
            System.out.println(num);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        visit = new boolean[N][N];
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
