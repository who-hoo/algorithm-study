import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Number {
        int number;
        String commands;

        public Number(int number, String commands) {
            this.number = number;
            this.commands = commands;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int number, target;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            calculate(number, target);
        }
    }

    private static void calculate(int number, int target) {
        boolean[] visited = new boolean[10000];
        Queue<Number> numbers = new LinkedList<>();
        numbers.add(new Number(number, ""));
        visited[number] = true;

        int newNumber;
        while (!numbers.isEmpty()) {

            Number n = numbers.poll();

            newNumber = d(n.number);
            if (newNumber == target) {
                System.out.println(n.commands + "D");
                return;
            }

            if (!visited[newNumber]) {
                visited[newNumber] = true;
                numbers.add(new Number(newNumber, n.commands + "D"));
            }

            newNumber = s(n.number);
            if (newNumber == target) {
                System.out.println(n.commands + "S");
                return;
            }

            if (!visited[newNumber]) {
                visited[newNumber] = true;
                numbers.add(new Number(newNumber, n.commands + "S"));
            }

            newNumber = l(n.number);
            if (newNumber == target) {
                System.out.println(n.commands + "L");
                return;
            }

            if (!visited[newNumber]) {
                visited[newNumber] = true;
                numbers.add(new Number(newNumber, n.commands + "L"));
            }

            newNumber = r(n.number);
            if (newNumber == target) {
                System.out.println(n.commands + "R");
                return;
            }

            if (!visited[newNumber]) {
                visited[newNumber] = true;
                numbers.add(new Number(newNumber, n.commands + "R"));
            }
        }
    }

    private static int d(int number) {
        return number * 2 % 10000;
    }

    private static int s(int number) {
        return number == 0 ? 9999 : number - 1;
    }

    private static int l(int number) {
        return number % 1000 * 10 + number / 1000;
    }

    private static int r(int number) {
        return number % 10 * 1000 + number / 10;
    }
}
