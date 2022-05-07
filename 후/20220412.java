import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int cnt = 1;
        int number = 666;
        while (cnt < n) {
            number++;
            cnt = String.valueOf(number).contains("666") ? cnt + 1 : cnt;
        }

        System.out.println(number);
    }
}
