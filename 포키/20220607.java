import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> frame = new LinkedHashSet<>();
        Map<Integer, Integer> recommend = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int recommendedNumber = Integer.parseInt(st.nextToken());

            if (frame.size() == n) {
                if (frame.contains(recommendedNumber)) {
                    recommend.put(recommendedNumber, recommend.get(recommendedNumber) + 1);
                    continue;
                } else {
                    int key = frame.stream()
                        .min(Comparator.comparing(recommend::get))
                        .stream().findFirst().get();
                    frame.remove(key);
                    recommend.remove(key);
                }
            }
            frame.add(recommendedNumber);
            if (recommend.containsKey(recommendedNumber)) {
                recommend.put(recommendedNumber, recommend.get(recommendedNumber) + 1);
            } else {
                recommend.put(recommendedNumber, 1);
            }
        }
        List<Integer> list = new ArrayList<>(frame);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
