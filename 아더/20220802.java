package 아더;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PRO_87377_교점에별만들기 {

    public static void main(String[] args) {
        PRO_87377_교점에별만들기 pro_87377_교점에별만들기 = new PRO_87377_교점에별만들기();

        int[][] line1 = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        int[][] line2 = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        int[][] line3 = {{1, -1, 0}, {2, -1, 0}};
        int[][] line4 = {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};

        System.out.println(Arrays.toString(pro_87377_교점에별만들기.solution(line1)));
        System.out.println(Arrays.toString(pro_87377_교점에별만들기.solution(line2)));
        System.out.println(Arrays.toString(pro_87377_교점에별만들기.solution(line3)));
        System.out.println(Arrays.toString(pro_87377_교점에별만들기.solution(line4)));
    }

    static class Line {
        int x, y, z;

        public Line(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Line line = (Line) o;
            return x == line.x && y == line.y && z == line.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }
    
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {
        String[] answer = {};
        List<Line> lines = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        int maxX = 0;
        int maxY = 0;
        int minX = 0;
        int minY = 0;

        for (int[] ints : line) {
            // line 클래스로 변환해서 리스트에 담기
            lines.add(new Line(ints[0], ints[1], ints[2]));
        }

        for (Line eachLine1 : lines) {
            for (Line eachLine2 : lines) {
                if (eachLine1.equals(eachLine2)) {
                    continue;
                }
                Point intersection = calculateIntersection(eachLine1, eachLine2);
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        // points에서 꺼내서 최댓값 ,최소값들 찾기
        for (Point point : points) {
            maxX = Math.max(maxX, point.x);
            maxY = Math.max(maxY, point.y);
            minX = Math.min(minX, point.x);
            minY = Math.min(minY, point.y);
        }

        // 정답 출력

        return answer;
    }

    private Point calculateIntersection(Line line1, Line line2) {
        if (((line1.x * line2.y) - (line1.y * line2.x) == 0)) {
            return null;
        }

        int x = ((line1.y * line2.z) - (line1.z * line2.y)) / ((line1.x * line2.y) - (line1.y * line2.x));
        int y = ((line1.z * line2.x) - (line1.x * line2.z)) / ((line1.x * line2.y) - (line1.y * line2.x));
    
        return new Point(x, y);
    }
}
