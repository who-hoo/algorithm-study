import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수
        st = new StringTokenizer(br.readLine());
        int knowPersonCount = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
        HashSet<Integer> knowPeople = new HashSet<>(knowPersonCount);
        while (knowPersonCount-- > 0) {
            knowPeople.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<ArrayList<Integer>> parties = new ArrayList<>(m);
        int partyIdx = 0;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int peopleCount = Integer.parseInt(st.nextToken()); // 파티에 오는 사람의 수
            parties.add(new ArrayList<>(peopleCount));
            while (peopleCount-- > 0) {
                parties.get(partyIdx).add(Integer.parseInt(st.nextToken()));
            }
            partyIdx++;
        }
        br.close();

        int answer = 0;
        for (int i = 0; i < parties.size(); i++) {
            boolean isHere;
            ArrayList<Integer> currentParty = parties.get(i);
            if (currentParty.stream().noneMatch(comePerson -> knowPeople.contains(comePerson))) {
                isHere = false;
                for (int j = i + 1; j < parties.size(); j++) {
                    ArrayList<Integer> party = parties.get(j);
                    if (party.stream().anyMatch(comePerson -> currentParty.contains(comePerson))
                        && party.stream().anyMatch(comePerson -> knowPeople.contains(comePerson))) {
                        isHere = true;
                        knowPeople.addAll(currentParty);
                        break;
                    }
                }
            } else {
                isHere = true;
                knowPeople.addAll(currentParty);
            }
            if (!isHere) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
