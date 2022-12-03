import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int N, answer;
    static int[] nums;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(answer);
    }

    private static void solve() {
        for (int i = 2; i <= N; i++) {
            // i가 소수라면 합한다
            if (isPrime(i)) {
                answer += nums[i];
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        answer = 0;

        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(split[i - 1]);
        }
    }
}
