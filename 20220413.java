import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int titleNumber = Integer.parseInt(br.readLine());

        int firstValue = 666;
        int count = 1;
        while (true) {
            if (count == titleNumber) {
                System.out.println(firstValue);
                return;
            }
            firstValue++;
            int temp = firstValue;
            while (temp > 1) {
                if (temp % 1000 == 666) {
                    count++;
                    break;
                }
                temp /= 10;
            }
        }
    }
}
