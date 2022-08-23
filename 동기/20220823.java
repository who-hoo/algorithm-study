import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Main m = new Main();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(m.solution(A, B));
        }
    }

    public String solution(int a, int b) {

        // 입력값 a를 b가 되게끔 연산자 d, s, l, r 을 사용한다
        // d 두배를 만들기 위해서 먼저 한다
        // d 를 작동하면 입력값 a의 값을 두배로 늘린다.
        // 입력값 a가 9999보다 큰 값이 되면 10000 으로 나눈 나머지가 결과가된다.

        // 어떻게 하면 입력값 b에 도달할 수 있는 값이 만들어질까
        // 아 1000 을 commandL 메서드에 넣으면 0001

        // 1234를 넣으면 3412를 만들기 위해 commandL을 두 번 사용하는 것이 최소한의 명령어다
        // 1234를 넣으면 다 해봐야하는 거 같은데..
        // 1234를 넣으면 commandD를 동작할 시 3번만 해도 그냥 b값보다 커져버린다
        // 그러면 다음 command를 사용

        // bfs.
        StringBuilder result = bfs(a, b);
        return result.toString();
    }

    private StringBuilder bfs(int a, int b) {
        StringBuilder result = new StringBuilder();
        boolean[] visited = new boolean[10000];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;

        int newNumber;
        while (!queue.isEmpty()) {
            int pollInt = queue.poll();

            newNumber = commandD(pollInt);
            if (newNumber == b) {
                result.append("D");
                return result;
            }

            if (!visited[newNumber]) {
                visited[newNumber] = true;
                queue.add(newNumber);
                result.append("D");
            }

            newNumber = commandS(pollInt);
            if (newNumber == b) {
                result.append("S");
                return result;
            }

            if (!visited[newNumber]) {
                visited[newNumber] = true;
                queue.add(newNumber);
                result.append("S");
            }

            newNumber = commandL(pollInt);
            if (newNumber == b) {
                result.append("L");
                return result;
            }

            if (!visited[newNumber]) {
                visited[newNumber] = true;
                queue.add(newNumber);
                result.append("L");
            }

            newNumber = commandR(pollInt);
            if (newNumber == b) {
                result.append("R");
                return result;
            }

            if (!visited[newNumber]) {
                visited[newNumber] = true;
                queue.add(newNumber);
                result.append("R");
            }
        }
        return result;
    }

    public int commandR(int a) {
        int result = 0;
        int i = a / 10;
        int j = (a % 10) * 1000;
        result = zeroOrValue(i, j);

        return result;
    }

    public int commandS(int a) {
        a -= 1;
        if (a < 0) {
            return 9999;
        }
        return a;
    }

    public int commandD(int a) {
        a *= 2;
        if (a > 9999) {
            a %= 10000;
        }
        return a;
    }

    public int commandL(int a) {
        int result = 0;
        int i = (a % 1000) * 10;
        int j = a / 1000;
        result = i + j;
        return result;
    }

    private int zeroOrValue(int modValue, int a) {
        if (a == 0) {
            return modValue * 10;
        } else {
            return modValue + a;
        }
    }
}
