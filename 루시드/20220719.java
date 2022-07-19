package AlgorithmStudy.boj14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int result = Integer.MAX_VALUE;
    static List<Integer> arr;
    static int[][] ability;
    static List<Integer> sumResult;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ability = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(split[j]);
            }
        }

        arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        boolean[] visited = new boolean[arr.size()];
        comb(visited, 0, n / 2);

        System.out.println(result);
    }

    static void comb(boolean[] visited, int start, int r) {
        if (r == 0) {
            calculate(visited);
            return;
        }
        for (int i = start; i < arr.size(); i++) {
            visited[i] = true;
            comb(visited, i + 1, r - 1);
            visited[i] = false;
        }
    }

    static void calculate(boolean[] visited) {
        List<Integer> startTeam = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (visited[i]) {
                startTeam.add(arr.get(i));
            }
        }

        List<Integer> linkTeam = new ArrayList<>(arr);
        linkTeam.removeAll(startTeam);

        sumResult = new ArrayList<>();
        addAll(startTeam, new boolean[startTeam.size()], 0, 2);
        addAll(linkTeam, new boolean[linkTeam.size()], 0, 2);

        result = Math.min(result, Math.abs(sumResult.get(0) - sumResult.get(1)));
    }

    private static void addAll(List<Integer> team, boolean[] visited, int start, int count) {
        if (count == 0) {
            sumResult.add(sumValue(team, visited));
        }
        for (int i = start; i < team.size(); i++) {
            visited[i] = true;
            addAll(team, visited, i + 1, count - 1);
            visited[i] = false;
        }
    }

    private static int sumValue(List<Integer> team, boolean[] visited) {
        List<Integer> results = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            if (visited[i]) {
                results.add(team.get(i));
            }
        }

        Integer idx1 = results.get(0);
        Integer idx2 = results.get(1);

        sum += (ability[idx1 - 1][idx2 - 1] + ability[idx2 - 1][idx1 - 1]);
        return sum;
    }
}
