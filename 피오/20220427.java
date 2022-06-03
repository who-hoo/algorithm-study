// 감시(골드5)
package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683 {

    public static int n;
    public static int m;
    public static int[][] office;
    public static int[][] officeCopy;
    public static int blindSpotCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로
        office = new int[n][m];


        //배열 초기화 (0: 빈 칸/ 6: 벽/ 1~5: CCTV
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                //cctv 좌표 저장
                if (office[i][j] != 0 && office[i][j] != 6) {
                    points.add(new Point(office[i][j], i, j));
                }
            }
        }

        //cctv 번호가 낮은 순으로 정렬
        Collections.sort(points);
        for (Point point : points) {
            System.out.println("cctvNum: " + point.cctvNum + ", x: " + point.x + ", y: " + point.y);
        }

        for (int i = 0; i < points.size(); i++) {

        }


        blindSpotCount = Math.min(blindSpotCount, getBlindSpotCount());
        System.out.println(blindSpotCount);

        //출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(office[i][j]);
            }
            System.out.println();
        }



    }

    private static int getBlindSpotCount() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (officeCopy[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Point implements Comparable<Point> {

    public int cctvNum;
    public int y;
    public int x;

    public Point(int cctvNum, int y, int x) {
        this.cctvNum = cctvNum;
        this.y = y;
        this.x = x;
    }

    @Override
    public int compareTo(Point o) {
        return this.cctvNum - o.cctvNum;
    }
}
