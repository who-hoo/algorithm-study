package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_2606 { //바이러스 실버3

    private static int n;
    private static int m;
    private static Map<Integer, List<Integer>> computers = new HashMap<>();
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] numStrings = br.readLine().split(" ");
            int a = Integer.parseInt(numStrings[0]);
            int b = Integer.parseInt(numStrings[1]);

            List<Integer> nodesAdjacentA = computers.getOrDefault(a, new ArrayList<>());
            List<Integer> nodesAdjacentB = computers.getOrDefault(b, new ArrayList<>());
            nodesAdjacentA.add(b);
            nodesAdjacentB.add(a);
            computers.put(a, nodesAdjacentA);
            computers.put(b, nodesAdjacentB);
        }
        visited[1] = true;
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int start) {
        List<Integer> nodes = computers.get(start);
        for (int i = 0; i < nodes.size(); i++) {
            int nextNode = nodes.get(i);
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode);
                count++;
            }
        }
    }

}

