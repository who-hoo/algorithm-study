import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        List<String> l = new ArrayList<>();

        for (int i = 0; i < n + m; i++) {
            l.add(sc.nextLine());
        }

        Collections.sort(l);


        List<String> a = new ArrayList<>();
        for (int i = 0; i < n + m-1; i++) {
            if (l.get(i).equals(l.get(i + 1))) {
                a.add(l.get(i));
            }
        }

        System.out.println(a.size());
        for (String name : a) {
            System.out.println(name);
        }
    }
}
