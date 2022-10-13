package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2531_회전초밥 {

    static int N, d, k, c;
    static ArrayList<Integer> sushies = new ArrayList<>();

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        d = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);
        c = Integer.parseInt(split[3]);

        for (int i = 0; i < N; i++) {
            sushies.add(Integer.parseInt(br.readLine()));
        }
    }
}
