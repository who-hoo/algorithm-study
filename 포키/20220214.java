import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int c = 0;

        while (true) {
            if (n % 5 == 0) {
                c += n / 5;
                break;
            } else{
                n -= 3;
                c ++;
            }
            if (n < 0) {
                c = -1;
                break;
            }
        }
        System.out.println(c);
    }
}



/*
        if (n == 4) {
            System.out.println( -1);
        }
        if (n == 3) {
            System.out.println(1);
        }

        int t = 0;
        int f = n / 5;

        while (f >= 0) {
            int r = n - (f * 5);
            if (r == 0) {
                break;
            }
            if (r < 3 || r == 4) {
                f--;
                continue;
            } else {
                t = r / 3;
                if (r % 3 == 0) {
                    break;
                } else {
                    f--;
                    continue;
                }
            }
        }

        System.out.println(t + f != 0 ? t + f : -1);
 */