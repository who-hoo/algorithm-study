import java.io.*;

public class Main {
    static int N, MAX, MIN;
    static int[] operands, operators;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        rec_func(0, operands[0]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void rec_func(int k, int value) {
        if (k == N - 1) {
            MAX = Math.max(MAX, value);
            MIN = Math.min(MIN, value);
        } else {
            for (int cand = 0; cand < 4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    rec_func(k + 1, calc(value, cand, operands[k + 1]));
                    operators[cand]++;
                }
            }
        }
    }

    private static int calc(int operand1, int operator, int operand2) {
        if (operator == 0) {
            return operand1 + operand2;
        }
        if (operator == 1) {
            return operand1 - operand2;
        }
        if (operator == 2) {
            return operand1 * operand2;
        }
        return operand1 / operand2;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;
        operands = new int[N];
        operators = new int[4];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            operands[i] = Integer.parseInt(split[i]);
        }

        split = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(split[i]);
        }
    }
}
