import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Status{
    int spot;
    int count;

    public Status(int spot, int count) {
        this.spot = spot;
        this.count = count;
    }
}
public class Main {

    static boolean[] chk;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // for ladder
        int M = Integer.parseInt(st.nextToken()); // for snake
        chk = new boolean[101]; // default == false
        result = 100;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }

        Queue<Status> queue = new LinkedList<>();
        queue.offer(new Status(1, 0));

        while(!queue.isEmpty()) {

            Status s = queue.poll();

            if(s.spot == 100) {
                result = Math.min(result, s.count);
            }

            for(int i=1; i<=6; i++) {
                int tmp = s.spot + i;
                if(tmp>100 || chk[tmp]) {
                    continue;
                }
                chk[tmp] = true;

                if(map.containsKey(tmp)) {
                    queue.add(new Status(map.get(tmp), s.count+1));
                    continue;
                }
                queue.add(new Status(tmp, s.count+1));
            }
        }
        System.out.println(result);
    }
}
