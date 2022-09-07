import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<List<Integer>> connection;
    static int N;
    static boolean[] chk;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        connection = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            connection.add(new ArrayList<>());
        }

        int n1, n2;
        while (count-- > 0) {
            String[] node = br.readLine().split(" ");
            n1 = Integer.parseInt(node[0]);
            n2 = Integer.parseInt(node[1]);
            connection.get(n1).add(n2);
            connection.get(n2).add(n1);
        }

        chk = new boolean[N + 1];
        chk[1] = true;

        DFS(1);
        System.out.println(result);
    }

    private static void DFS(int num) {
        List<Integer> list = connection.get(num);
        for (Integer i : list) {
            if (!chk[i]) {
                chk[i] = true;
                result++;
                DFS(i);
            }
        }
    }
}
