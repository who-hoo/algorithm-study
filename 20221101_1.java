import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 마을의 수
        int c = Integer.parseInt(split[1]); // 트럭의 용량
        int m = Integer.parseInt(br.readLine()); // 박스 정보의 개수

        StringTokenizer st;
        Delivery[] deliveries = new Delivery[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            deliveries[i] = new Delivery(from, to, count);
        }
        Arrays.sort(deliveries);

        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = c;
        }
    }

}

class Delivery implements Comparable<Delivery> {

    int from;
    int to;
    int count;

    public Delivery(int from, int to, int count) {
        this.from = from;
        this.to = to;
        this.count = count;
    }

    @Override
    public int compareTo(Delivery o) {
        if (to == o.to) {
            return from - o.from;
        }
        return to - o.to;
    }
}
