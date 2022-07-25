package 아더;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_81302_거리두기확인하기2 {

    public static void main(String[] args) {
        Pro_81302_거리두기확인하기2 sol = new Pro_81302_거리두기확인하기2();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[] solution = sol.solution(places);
        System.out.println(Arrays.toString(solution));
    }

    class People {
        int row;
        int col;

        public People(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        // 하나의 맵씩 처리
        for (int i = 0; i < 5; i++) {
            // 사람 위치를 모은 큐
            Queue<People> que = extractPeople(places[i]);
            answer[i] = 1;

            while (!que.isEmpty()) {
                People people = que.poll();
                // 상하좌우 1의 거리
                if (isNearByPeopleLURD(people, places[i])) {
                    answer[i] = 0;
                    break;
                }

                // 상하좌우 2의 거리
                if (isNearByPeopleLURD2(people, places[i])) {
                    answer[i] = 0;
                    break;
                }

                // 대각선 거리
                if (isNearByPeopleDiagonal(people, places[i])) {
                    answer[i] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    private boolean isNearByPeopleLURD(People people, String[] places) {
        int dir[][] = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for (int i = 0; i < 4; i++) {
            int nx  = people.row + dir[i][0];
            int ny  = people.col + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if (places[nx].charAt(ny) == 'P') {
                return true;
            }
        }
        return false;
    }

    private boolean isNearByPeopleLURD2(People people, String[] places) {
        int dir[][] = {{0, -2}, {-2, 0}, {0, 2}, {2, 0}};

        for (int i = 0; i < 4; i++) {
            int nx  = people.row + dir[i][0];
            int ny  = people.col + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if (places[nx].charAt(ny) == 'P') {
                if (places[people.row + (dir[i][0] / 2)].charAt(people.col + (dir[i][1] / 2)) != 'X') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNearByPeopleDiagonal(People people, String[] places) {
        int dir[][] = {{-1, -1}, {1, -1}, {1, 1}, {-1, 1}};

        for (int i = 0; i < 4; i++) {
            int nx = people.row + dir[i][0];
            int ny = people.col + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if (places[nx].charAt(ny) == 'P') {
                if (!(places[people.row + dir[i][0]].charAt(people.col) == 'X' && places[people.row].charAt(people.col + dir[i][1]) == 'X')) {
                    return true;
                }
            }
        }
        return false;
    }

    private Queue<People> extractPeople(String[] places) {
        Queue<People> que = new LinkedList<>();

        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                if (places[j].charAt(k) == 'P') {
                    que.add(new People(j, k));
                }
            }
        }

        return que;
    }
}
