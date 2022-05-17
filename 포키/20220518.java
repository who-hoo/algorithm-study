package level2;

import java.util.ArrayList;
import java.util.List;

public class 빛의_경로_사이클 {
    public int[] solution(String[] grid) {
        int[] answer = {};

        int rowLength = grid.length;
        int columnLength = grid[0].length();

        //up(0,0), down(1,1), left(2,2), right(3,3)
        int[] rowDirection = {0, 0, -1, 1};
        int[] columnDirection = {-1, 1, 0, 0};

        String[][] map = new String[rowLength][columnLength];

        //문자열을 2차원 배열에 담는 작업
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                map[i][j] = String.valueOf(grid[i].charAt(j));
            }
        }

        List<Integer> result = new ArrayList<>();

        while (true) {
            int count = 0;
            int row = 0;
            int column = 0;


            if (map[row][column].equals("L")) {
                //좌회전
            } else if (map[row][column].equals("R")) {
                //우회전
            }else{
                //직진
            }

            //이미 true인 방향을 만나면 끝.
            //빈 방향이 남아있으면 continue;
            //방향 4개가 모두 true면 break;

        }


        return null;
    }
}

//S : 직진
//L : 좌회전
//R : 우회전
//이미 갔던 방향으로 다시 올 경우 하나의 사이클 종료
