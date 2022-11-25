import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int n, max = (int) -1e9, min = (int) 1e9;
    static int[] numbers, picked;
    static List<Integer> operations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        picked = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                operations.add(i);
            }
        }

        backTrack(0, 0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void backTrack(int depth, int flag) {
        if (depth == n - 1) {
            calculate();
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if ((flag & 1 << i) == 0) {
                picked[depth] = operations.get(i);
                backTrack(depth + 1, flag | 1 << i);
            }
        }
    }

    private static void calculate() {
        int sum = numbers[0];
        for (int i = 1; i <= n - 1; i++) {
            switch (picked[i - 1]) {
                case 0 : {
                    sum += numbers[i];
                    break;
                } case 1 : {
                    sum -= numbers[i];
                    break;
                } case 2 : {
                    sum *= numbers[i];
                    break;
                } default : {
                    sum /= numbers[i];
                }
            }
        }

        max = Math.max(max, sum);
        min = Math.min(min, sum);
    }

}
