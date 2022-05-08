import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long m = sc.nextInt();
        List<Integer> trees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            trees.add(sc.nextInt());
        }
        Collections.sort(trees);

        long result= 0;
        int start = 0;
        int end = trees.get(trees.size() - 1);


        while (start <= end) {
            int h = (start + end) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree > h) {
                    sum += tree - h;
                }
            }

            if (sum < m) {
                end = h - 1;
            } else {
                result = h;
                start = h + 1;
            }
        }
        System.out.println(result);
    }
}

// H = 절단기 높이
// H를 지정하면 톱날이 땅으로부터 H만큼 올라간다.
// N = 나무의 수
// M = 가져가야하는 나무의 길이


//파라메트릭 서치
//start = 0;
//end = trees 중에 가장 큰 값
