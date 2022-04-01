import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int knowPeopleCount = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < knowPeopleCount; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> partyList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            partyList.add(new ArrayList<>());
        }

        int visitPeopleCount;
        int curPeople;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            visitPeopleCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < visitPeopleCount; j++) {
                curPeople = Integer.parseInt(st.nextToken());
                partyList.get(i).add(curPeople);
            }
        }

        boolean chk;
        do {
            chk = false;
            for (List<Integer> list : partyList) {
                if (set.containsAll(list)) {
                    continue;
                }
                for (Integer value : list) {
                    if (set.contains(value)) {
                        chk = true;
                        set.addAll(list);
                        break;
                    }
                }
            }
        } while (chk);

        int result = 0;
        for (List<Integer> list : partyList) {
            if (set.containsAll(list)) {
                continue;
            }
            result++;
        }
        System.out.println(result);
    }
}
