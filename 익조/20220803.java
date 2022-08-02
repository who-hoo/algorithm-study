import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        numbers[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken()) + numbers[i - 1];
        }

        int pointer, sum, result = 100000;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            pointer = numbers[i];
            if (pointer >= s) {
                result = Math.min(result, i + 1);
                flag = false;
            }
            for (int j = i + 1; j < n; j++) {
                sum = numbers[j] - pointer;
                if (sum >= s) {
                    result = Math.min(result, j - i);
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(0);
            return;
        }

        System.out.println(result);
    }
}
