import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Solution {

    static List<List<Integer>> lists;
    static int diff = Integer.MAX_VALUE;
    static Set<Disconnect> check = new HashSet<>();
    static boolean[] chk;
    static int all;

    public int solution(int n, int[][] wires) {
        lists = new ArrayList<>();
        all = n;
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int a1 = wire[0];
            int a2 = wire[1];
            lists.get(a1).add(a2);
            lists.get(a2).add(a1);
        }

        for (int i = 1; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                Integer curValue = lists.get(i).get(j);
                Disconnect tmp = new Disconnect(i, curValue);
                if (check.contains(tmp)) {
                    continue;
                }
                check.add(tmp);
                chk = new boolean[n + 1];
                BFS(tmp);
            }
        }
        return diff;
    }

    private void BFS(Disconnect disconnect) {
        Queue<Integer> queue = new LinkedList<>();
        int result = 1;
        chk[1] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                List<Integer> list = lists.get(poll);
                for (Integer tmp : list) {
                    if (chk[tmp]) {
                        continue;
                    }
                    chk[tmp] = true;
                    Disconnect tmpDisCon = new Disconnect(poll, tmp);
                    if (disconnect.equals(tmpDisCon)) {
                        continue;
                    }
                    result++;
                    queue.offer(tmp);
                }
            }
        }
        int dif = all - result;
        diff = Math.min(diff, Math.abs(dif - result));
    }

    static class Disconnect {
        int n1;
        int n2;

        public Disconnect(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Disconnect that = (Disconnect)o;
            return (n1 == that.n1 && n2 == that.n2) || (n1 == that.n2 && n2 == that.n1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(n1, n2);
        }
    }
}
