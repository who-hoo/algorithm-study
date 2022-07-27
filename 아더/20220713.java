package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_12865_평범한배낭 {

    static int N, K;
    static int[] DP;
    static List<WeightValue> weightValues;

    static class WeightValue {
        int weight, value;

        public WeightValue(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

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
        System.out.println(DP[K]);
    }

    private static void solve() {
        for (WeightValue weightValue : weightValues) {
            for (int j = K; j >= weightValue.weight; j--) {
                DP[j] = Math.max(DP[j], DP[j - weightValue.weight] + weightValue.value);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        weightValues = new ArrayList<>();
        DP = new int[K + 1];

        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            int weight = Integer.parseInt(split[0]);
            int value = Integer.parseInt(split[1]);
            weightValues.add(new WeightValue(weight, value));
        }
    }
}
