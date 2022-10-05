import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int[] arr = new int[n+1];

        String[] numbers = br.readLine().split(" ");

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }


        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int result = 100001;
        while (p1 <= p2 && p2 <= n) {
            if (sum >= s) {
                sum -= arr[p1];
                result = Math.min(result, p2 - p1);
                p1++;
            } else {
                sum += arr[p2];
                p2++;
            }
        }

        if (result == 100001) {
            System.out.println(0);
        }else{
            System.out.println(result);
        }
    }
}