import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, m, t;
    static int[] students;
    static int[][] roads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        students = new int[n + 1];

        roads = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i != j)
                    roads[i][j] = 1000001;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            roads[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    roads[j][k] = Math.min(roads[j][k], roads[j][i] + roads[i][k]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            students[i] = roads[i][t] + roads[t][i];
        }

        System.out.println(getMaxValue(students));
    }

    private static int getMaxValue(int[] students) {
        int result = 0;
        for (int student : students) {
            result = Math.max(student, result);
        }

        return result;
    }

}
