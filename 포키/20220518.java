package level2;

import java.util.ArrayList;
import java.util.List;

public class 빛의_경로_사이클 {

    //up(0,0), left(1,1), right(2,2), down(1,1)
    private static int[] rowDirection = {0, -1, 0, 1};
    private static int[] columnDirection = {-1, 0, 1, 0};

    public int[] solution(String[] grid) {
        int rowLength = grid[0].length();
        int columnLength = grid.length;

        Node[][] map = new Node[columnLength][rowLength];

        //문자열을 2차원 배열에 담는 작업
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                map[i][j] = new Node(grid[i].charAt(j));
            }
        }

        List<Integer> result = new ArrayList<>();


        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                //하나의 점에 대해 4방향 확인하기
                for (int k = 0; k < 4; k++) {
                    result.add(helper(map, j, i, k));
                }
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .filter(i -> i > 0)
                .sorted()
                .toArray();
    }

    public int helper(Node[][] map, int currentRow, int currentColumn, int direction) {
        int count = 0;

        //이동하게 될 위치
        int row = currentRow + rowDirection[direction];
        int column = currentColumn + columnDirection[direction];

        while (true) {

            //끝에 도착하면 돌아가도록
            if (row < 0) {
                row = map[0].length - 1;
            }
            if (row >= map[0].length) {
                row = 0;
            }
            if (column < 0) {
                column = map.length - 1;
            }
            if (column >= map.length) {
                column = 0;
            }

            //현재 노드의 direction이 true면 종료
            if (map[column][row].direction[direction]) {
                break;
            }

            map[column][row].direction[direction] = true;

            if (map[column][row].type == 'L') {
                //좌회전
                //up0 -> left 1
                //left1 -> down2
                //down2 -> right3
                //right3 -> up 0
                if (direction < 3) {
                    direction++;
                } else {
                    direction = 0;
                }
            } else if (map[column][row].type == 'R') {
                //우회전
                //up0 -> right 3
                //left1 -> up0
                //down2 -> left1
                //right3 -> down 2

                if (direction == 0) {
                    direction = 3;
                } else {
                    direction--;
                }
            }

            row += rowDirection[direction];
            column += columnDirection[direction];

            count++;
        }

        return count;
    }


    public class Node {
        char type;
        boolean[] direction = new boolean[4];

        public Node(char type) {
            this.type = type;
        }
    }
}


//S : 직진
//L : 좌회전
//R : 우회전
//이미 갔던 방향으로 다시 올 경우 하나의 사이클 종료
