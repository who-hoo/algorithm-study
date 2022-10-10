import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1780 {

    private static int n;
    private static int[][] map;
    private static Map<Integer, Integer> counts;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //초기화
        setMap(br);
        setCounts();

        divide(0, 0, n, map[0][0]);

        counts.values().stream()
            .forEach(System.out::println);

    }

    private static void divide(int row, int column, int l, int baseNumber) {
        boolean status = true;
        for (int i = row; i < row + l; i++) {
            for (int j = column; j < column + l; j++) {
                if (map[i][j] != baseNumber) {
                    status = false;
                    break;
                }
            }
        }
        if (status) {
            counts.put(baseNumber, counts.get(baseNumber) + 1);
        }else{
            //가로 세로 3등분
            int newL = l / 3;
            //첫번째 줄
            divide(row, column, newL, map[row][column]);
            divide(row, column + newL, newL, map[row][column + newL]);
            divide(row, column + (newL * 2), newL, map[row][column + (newL * 2)]);

            //두번째 줄
            divide(row + newL, column, newL, map[row + newL][column]);
            divide(row + newL, column + newL, newL, map[row + newL][column + newL]);
            divide(row + newL, column + (newL * 2), newL, map[row + newL][column + (newL * 2)]);

            //세번째 줄
            divide(row + (newL * 2), column, newL, map[row + (newL * 2)][column]);
            divide(row + (newL * 2), column + newL, newL, map[row + (newL * 2)][column + newL]);
            divide(row + (newL * 2), column + (newL * 2), newL, map[row + (newL * 2)][column + (newL * 2)]);
        }
    }

    private static void setCounts() {
        counts = new LinkedHashMap<>();
        counts.put(-1, 0);
        counts.put(0, 0);
        counts.put(1, 0);
    }

    private static void setMap(BufferedReader br) throws IOException {
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
