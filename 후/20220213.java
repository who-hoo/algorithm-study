import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int threeCnt = 0;
        int fiveCnt = 0;
        int result = 0;
        while (true) {
            if (n < 0) {
                result = -1;
                break;
            }
            if (n % 5 == 0) {
                fiveCnt = n / 5;
                break;
            }
            n -= 3;
            threeCnt++;
        }
        result = (result == -1) ? result : threeCnt + fiveCnt;

        System.out.println(result);
    }
}
