import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    static class Party {

        List<Integer> party;
        boolean exaggerationIsPossible;

        public Party(List<Integer> party, boolean exaggerationIsPossible) {
            this.party = party;
            this.exaggerationIsPossible = exaggerationIsPossible;
        }

        public boolean contains(int person) {
            return party.contains(person);
        }
    }

    public static void main(String[] args) throws IOException {

        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 진실을 판별할 수 있는 사람들 입력
        st = new StringTokenizer(br.readLine());
        int countOfTruthfulPerson = Integer.parseInt(st.nextToken());

        if (countOfTruthfulPerson == 0) {
            System.out.println(m);
            return;
        }

        Set<Integer> truthfulPerson = new HashSet<>();

        for (int i = 0; i < countOfTruthfulPerson; i++) {
            truthfulPerson.add(Integer.parseInt(st.nextToken()));
        }

        List<Party> parties = new ArrayList<>();

        // 파티에 참석하는 사람들 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int countOfPersonInParty = Integer.parseInt(st.nextToken());
            List<Integer> personInParty = new ArrayList<>();

            for (int j = 0; j < countOfPersonInParty; j++) {
                personInParty.add(Integer.parseInt(st.nextToken()));
            }

            parties.add(new Party(personInParty, true));
        }

        // 진실을 판별할 수 있는 사람들 추가 및 진실을 말 할 수 없는 파티 체크(check)
        Set<Integer> tempSet = new HashSet<>(truthfulPerson);
        Queue<Integer> truthfulPersonQueue = new LinkedList<>(tempSet);

        while (!truthfulPersonQueue.isEmpty()) {

            int tp = truthfulPersonQueue.poll();

            for (Party party : parties) {
                if (party.exaggerationIsPossible && party.contains(tp)) {
                    party.exaggerationIsPossible = false;
                    for (int p : party.party) {
                        truthfulPerson.add(p);
                        tempSet.add(p);
                    }
                }
            }

            tempSet.remove(tp);
            truthfulPersonQueue = new LinkedList<>(tempSet);
        }

        // 결과값 출력
        for (Party party : parties) {
            if (party.exaggerationIsPossible) result++;
        }

        System.out.println(result);
    }
}
