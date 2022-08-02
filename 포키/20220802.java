package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class 교점에_별만들기 {

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public String[] solution(int[][] line) {


        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            int[] abc = line[i];
            int a = abc[0];
            int b = abc[1];
            int e = abc[2];

            for (int j = i + 1; j < line.length; j++) {
                int[] def = line[j];
                int c = def[0];
                int d = def[1];
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

        int maxX = 0;
        int minX = 0;
        int maxY = 0;
        int minY = 0;

        for (Point point : points) {
            maxX = Math.max(maxX, point.x);
            minX = Math.min(minX, point.x);
            maxY = Math.max(maxY, point.y);
            minY = Math.min(minY, point.x);
        }

        int width = maxX - minX + 1;
        int height = maxY - minY;


        String[] result = new String[height + 1];

        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j <= width; j++) {
                int curI = i;
                int curJ = j;
                Optional<Point> point = points.stream()
                        .filter(p -> (p.x) == curJ && p.y == curI)
                        .findFirst();

                if (point.isEmpty()) sb.append('.');
                else sb.append('*');
            }
            result[i] = sb.toString();
        }


        return result;
    }

    public static void main(String[] args) {
        교점에_별만들기 s = new 교점에_별만들기();

        int[][] l = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        String[] solution = s.solution(l);

        for (String s1 : solution) {
            System.out.println(s1);
        }
    }
}

// x = BF-ED / AD-BC
// y = EC-AF / AD-BC

//AD-BC가 0이면 평행이거나 동일한것이므로 건너뛰기
//x, y 가 정수가 아닌 경우 건너뛰기
//정수인 교점들만 걸러서 저장.

//교점 찍어보기.
//교점 중 상하 좌우 가장 큰값을 사이즈로잡기.



