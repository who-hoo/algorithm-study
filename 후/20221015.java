import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static List<List<Integer>> combinations = new ArrayList<>();

    public int solution(String[][] relation) {
        int answer = 0;

        int[] colIdx = new int[relation[0].length];
        for (int i = 0; i < colIdx.length; i++) {
            colIdx[i] = i;
        }
        boolean[] visited = new boolean[colIdx.length];
        for (int i = 0; i < colIdx.length; i++) {
            combinations(colIdx, visited, 0, colIdx.length, i + 1);
        }

        for (List<Integer> combination : combinations) {
            List<String> tuples = new ArrayList<>();
            for (String[] tuple : relation) {
                StringBuilder sb = new StringBuilder();
                for (int index : combination) {
                    sb.append(tuple[index]);
                }
                tuples.add(sb.toString());
            }
            if (isUnique(tuples) && isMinimal(relation, combination)) {
                answer++;
            }
        }

        return answer;
    }

    private void combinations(int arr[], boolean visited[], int start, int n, int r) {
        if (r == 0) {
            combinations.add(combination(arr, visited, n));
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combinations(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private List<Integer> combination(int arr[], boolean visited[], int n) {
        List<Integer> comb = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                comb.add(arr[i]);
            }
        }
        return comb;
    }

    private boolean isUnique(List<String> tuples) {
        Set<String> duplicateChecker = new HashSet<>();
        for (String tuple : tuples) {
            if (!duplicateChecker.add(tuple)) {
                return false;
            }
        }
        return true;
    }

    private boolean isMinimal(String[][] relation, List<Integer> columnIndexes) {
        for (int excludeColumnIdx : columnIndexes) {
            List<String> tuples = new ArrayList<>();
            for (String[] row : relation) {
                StringBuilder sb = new StringBuilder();
                for (Integer columnIndex : columnIndexes) {
                    if (excludeColumnIdx != columnIndex) {
                        sb.append(row[columnIndex]);
                    }
                }
                tuples.add(sb.toString());
            }
            if (isUnique(tuples)) {
                return false;
            }
        }
        return true;
    }
}
