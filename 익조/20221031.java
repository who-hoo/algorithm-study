import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            deliveries.add(new Delivery(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(deliveries);

        int[] capacities = new int[n + 1];
        Arrays.fill(capacities, c);

        int result = 0;

        for (Delivery delivery : deliveries) {

            int capacity = 10001;

            for (int i = delivery.start; i < delivery.end; i++) {
                if (capacities[i] < delivery.boxCount) {
                    capacity = Math.min(capacity, capacities[i]);
                } else {
                    capacity = Math.min(capacity, delivery.boxCount);
                }
            }

            for (int i = delivery.start; i < delivery.end; i++) {
                capacities[i] -= capacity;
            }

            result += capacity;
        }

        System.out.println(result);
    }

    private static class Delivery implements Comparable<Delivery> {
        int start;
        int end;
        int boxCount;

        public Delivery(int start, int end, int boxCount) {
            this.start = start;
            this.end = end;
            this.boxCount = boxCount;
        }

        @Override
        public int compareTo(Delivery o) {
            if (end != o.end) {
                return end - o.end;
            }

            return start - o.start;
        }
    }
}
