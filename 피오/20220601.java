package beakjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main_1764 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();

//        List<String> notHeardEver = new ArrayList<>();
//        List<String> notSeenEver = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            notHeardEver.add(sc.nextLine());
//        }
//        for (int i = 0; i < m; i++) {
//            notSeenEver.add(sc.nextLine());
//        }
//
//        Collections.sort(notHeardEver, Collections.reverseOrder());
//        Collections.sort(notSeenEver, Collections.reverseOrder());
//
//        Queue<String> both = new LinkedList<>();
//        for (int i = notHeardEver.size() - 1; i >= 0; i--) {
//            String notHeard = notHeardEver.get(i);
//            for (int j = notSeenEver.size() - 1; j >= 0; j--) {
//                String notSeen = notSeenEver.get(j);
//                if (notHeard.charAt(0) - notSeen.charAt(0) < 0) {
//                    notHeardEver.remove(i);
//                    break;
//                }
//                if (notHeard.equals(notSeen)) {
//                    both.add(notHeard);
//                    notHeardEver.remove(i);
//                    notSeenEver.remove(j);
//                    break;
//                }
//            }
//        }
//
//        System.out.println(both.size());
//        while (!both.isEmpty()) {
//            System.out.println(both.poll());
//        }

        Set<String> notHeardOrSeenEver = new HashSet<>();
        for (int i = 0; i < n; i++) {
            notHeardOrSeenEver.add(sc.nextLine());
        }

        List<String> notBoth = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = sc.nextLine();
            if (!notHeardOrSeenEver.add(name)) {
                notBoth.add(name);
            }
        }

        Collections.sort(notBoth);
        System.out.println(notBoth.size());
        for (int i = 0; i < notBoth.size(); i++) {
            System.out.println(notBoth.get(i));
        }
    }

}
