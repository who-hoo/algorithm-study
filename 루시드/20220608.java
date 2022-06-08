import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;


public class Main {

    static class Hubo {
        int val, up, day;

        public Hubo(int val, int up, int day) {
            this.val = val;
            this.up = up;
            this.day = day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Hubo> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.up == o2.up) {
                return o1.day - o2.day;
            }
            return o1.up - o2.up;
        });

        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = 0;
        while (M-- > 0) {
            int now = Integer.parseInt(st.nextToken());

            // 1. 목록에 포함되어있는지 확인한다.
            boolean chk = false;
            for (Hubo hubo : pq) {
                // 후보로 되어있으면 따봉수를 올린다. -> 아예 꺼낸 후 처리한다. pq에 새로 제공하는 시점에 소팅 되는 듯 하다.
                if (hubo.val == now) {
                    int uptmp = hubo.up;
                    int daytmp = hubo.day;
                    pq.remove(hubo);
                    pq.offer(new Hubo(now, uptmp + 1, daytmp));
                    chk = true;
                    break;
                }
            }

            // 1에서 체크되었으면 다음 추천을 확인하기 위해 넘긴다.
            if (chk) continue;

            // 2. 목록에 없다면 새로 넣어줘야 한다.

            // 목록에 여유가 있다면 새로 넣는다.
            if (pq.size() < N) {
                pq.offer(new Hubo(now, 1, day++));
                continue;
            }

            // 만약 목록이 꽉 찼다면, 가장 따봉이 낮고 오래된 녀석을 빼내야한다.
            pq.poll();
            pq.offer(new Hubo(now, 1, day++));
        }

        Stream<Hubo> sorted = pq.stream().sorted(Comparator.comparingInt(o -> o.val));

        int[] ints = sorted.mapToInt(o -> o.val).toArray();
        for (int a : ints) {
            System.out.print(a + " ");
        }
    }
}
