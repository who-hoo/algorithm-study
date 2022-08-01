import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 20220606 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] list = new int[n];
        String[] s = br.readLine().split(" ");

        list[0] = Integer.parseInt(s[0]);
        for (int i = 1; i < n; i++) {
            list[i] = Integer.parseInt(s[i]) + list[i - 1];
        }

        for (int i = 0; i < m; i++) {
            String[] range = br.readLine().split(" ");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            if (start == 1) {
                System.out.println(list[end - 1]);
            } else {
                System.out.println(list[end-1] - list[start-2]);
            }

        }

    }
}
