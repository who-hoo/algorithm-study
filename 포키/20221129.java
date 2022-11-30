import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiFunction;

public class BOJ14888 {

    private static int n;
    private static int[] nums;
    private static int[] commands;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    private static final BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
    private static final BiFunction<Integer, Integer, Integer> minus = (a, b) -> a - b;
    private static final BiFunction<Integer, Integer, Integer> multiple = (a, b) -> a * b;
    private static final BiFunction<Integer, Integer, Integer> divide = (a, b) -> a / b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        commands = new int[4];

        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }

        String[] c = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            commands[i] = Integer.parseInt(c[i]);
        }

        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int index, int number) {

        if (index == n) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (commands[i] > 0) {
                commands[i]--;
                int calculateResult = calculate(number, nums[index], i);
                dfs(index+1, calculateResult);
                commands[i]++;
            }
        }

    }

    public static int calculate(int num1, int num2, int index) {
        switch (index) {
            case 0:
                return sum.apply(num1, num2);
            case 1:
                return minus.apply(num1, num2);
            case 2:
                return multiple.apply(num1, num2);
            case 3:
                return divide.apply(num1, num2);
            default:
                return 0;
        }
    }


}
