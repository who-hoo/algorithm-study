```Java
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), sugar = N, result;

        if (N >= 5) {
            result = N / 5;
            N %= 5;
            if (N % 3 == 0) {
                result += N / 3;
            }
            else {
                while (true) {
                    result -= 1;
                    N += 5;
                    if (N % 3 == 0) {
                        result += N / 3;
                        break;
                    }
                    if (sugar == N) {
                        result = -1;
                        break;
                    }
                }
            }
        }
        else if (N == 3) {
            result = 1;
        }
        else {
            result = -1;
        }

        System.out.println(result);
    }
}
```
