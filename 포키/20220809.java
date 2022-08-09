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
    }
}