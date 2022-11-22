import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[1000001];
        int[] inputArr = new int[N];

        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i : inputArr) {
            if((X - i < 0) || (X - i > 1000000)) {
                continue;
            }
            if (arr[X - i] == 1) {
                result ++;
            }
            arr[i] = 1;
        }

        System.out.println(result);
    }
}
