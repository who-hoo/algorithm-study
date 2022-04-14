import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] trees;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(trees[0] - m);
            return;
        }

        Arrays.sort(trees);

        long sumOfCutTrees;
        int start = 0, end = trees[n - 1], heightOfSaw;
        int result = 0;

        while (start <= end) {
            heightOfSaw = (start + end) / 2;
            sumOfCutTrees = getSumOfCutTrees(heightOfSaw);

            if (sumOfCutTrees < m) {
                end = heightOfSaw - 1;
            }
            else if (sumOfCutTrees > m) {
                result = heightOfSaw > result ? heightOfSaw : result;
                start = heightOfSaw + 1;
            }
            else {
                result = heightOfSaw;
                break;
            }
        }

        System.out.println(result);
    }

    public static long getSumOfCutTrees(int heightOfSaw) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (trees[i] > heightOfSaw) {
                sum += trees[i] - heightOfSaw;
            }
        }

        return sum;
    }
}
