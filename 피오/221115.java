package baekjoon.main_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[][] board;
    private static int n, m;
    private static boolean[][] visited;
    private static List<int[]> houses = new ArrayList<>();
    private static List<int[]> chickens = new ArrayList<>();
    private static int minTotalChickenDistance = 999_999_999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    houses.add(new int[]{i + 1, j + 1});
                } else if (board[i][j] == 2) {
                    chickens.add(new int[]{i + 1, j + 1});
                }
            }
        }

        findWhoWillBeClosed();
        System.out.println(minTotalChickenDistance);
    }

    private static void findWhoWillBeClosed() {
        boolean[] visited = new boolean[chickens.size()];
        for (int i = 0; i < chickens.size(); i++) {
            combination(visited, i, 0);
        }
    }

    private static void combination(boolean[] visited, int start, int r) {
        if (r == m) {
            calDistance(visited);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            combination(visited, i + 1, r + 1);
            visited[i] = false;
        }
    }

    private static void calDistance(boolean[] visited) {
        int tempTotalChickenDistance = 0;

        //집을 꺼내가면서 가까운 치킨 집을 골라야 하기 때문에 집으로 루프를 돈다
        for (int i = 0; i < houses.size(); i++) {
            int[] house = houses.get(i);
            int tempChickenDistance = 999_999_999;
            for (int j = 0; j < visited.length; j++) {
                if (visited[j]) {
                    int[] chicken = chickens.get(j);
                    tempChickenDistance = Math.min(tempChickenDistance, Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]));
                }
            }
            //집 하나의 최소 치킨 거리를 구했으면 임시 총 치킨거리에 더해준다.
            tempTotalChickenDistance += tempChickenDistance;
        }
        minTotalChickenDistance = Math.min(minTotalChickenDistance, tempTotalChickenDistance);
    }
}
