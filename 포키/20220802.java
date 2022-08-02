package level2;

import java.util.ArrayList;
import java.util.List;

public class 교점에_별만들기 {

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {
        String[] answer = {};

//        12
//        23
//        34
//        45

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length-1; i++) {
            int[] abc = line[i];
            int a = abc[0];
            int b = abc[1];
            int c = abc[2];

            for (int j = i+1; j < line.length; j++) {
                int[] def = line[j];
                int d = def[0];
                int e = def[1];
                int f = def[2];

                int xNumerator = b * f - e * d;
                int yNumerator = e * c - a * f;
                int denominator = a * d - b * c;

                if (denominator == 0 || xNumerator % denominator != 0 || yNumerator % denominator != 0) continue;

                int x = xNumerator / denominator;
                int y = yNumerator / denominator;

                points.add(new Point(x, y));
            }
        }



        return answer;
    }
}

// x = BF-ED / AD-BC
// y = EC-AF / AD-BC

//AD-BC가 0이면 평행이거나 동일한것이므로 건너뛰기
//x, y 가 정수가 아닌 경우 건너뛰기
//정수인 교점들만 걸러서 저장.

//교점 찍어보기.
//교점 중 상하 좌우 가장 큰값을 사이즈로잡기.

