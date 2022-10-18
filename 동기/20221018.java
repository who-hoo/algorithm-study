import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // 후보키를 찾기 위해서는 유일성과 최소성을 만족해야한다
    // 유일성은 주민등록번호와 같이 중복이 없는 속성의 집합이 유일성을 만족하는 집합이 된다
    // 최소성을 만족한다는 것은 꼭 필요한 속성들로만 구성하는 것이다
    // 학번, 주민번호 합쳐서 후보키를 사용하기에는 학번 하나만으로도 가능하기에 이 경우엔 최소성을 만족시키지 못한다
    List<List<Integer>> combinations = new ArrayList<>();

    public int solution(String[][] relation) {
        int answer = 0;

        int[] columns = new int[relation[0].length];
        // 작성하고 보니 이건 왜?
        for (int i = 0; i < columns.length; i++) {
            columns[i] = i;
        }

        boolean[] visited = new boolean[columns.length];
        for (int i = 0; i < columns.length; i++) {
            combinations(columns, visited, 0, columns.length, i + 1);
        }

        for (List<Integer> combination : combinations) {
            List<String> tuples = new ArrayList<>();
            for (String[] tuple : relation) {
                StringBuilder sb = new StringBuilder();
                for (Integer index : combination) {
                    sb.append(tuple[index]);
                }
                tuples.add(sb.toString());
            }
            if (unique(tuples) && minimality(relation, combination)) {
                answer++;
            }
        }

        return answer;
    }

    private void combinations(int[] columns, boolean[] visited, int start, int n, int r) {
        // columns : 뽑고자 하는 배열
        // visited : 배열의 방문 여부 체크
        // n : 배열의 길이
        // r : 뽑고자 하는 순열의 개수
        if (r == 0) {
            combinations.add(combination(columns, visited, n));
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combinations(columns, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private List<Integer> combination(int[] arr, boolean[] visited, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) { // 인덱스를 방문한적이 없으면 list에 값 추가
                // arr에는 0, 1, 2, 3, 4, 5 등 relation[0].length 길이만큼 인덱스가 할당되어있음
                list.add(arr[i]);
            }
        }
        return list;
    }

    private boolean unique(List<String> tuples) {
        Set<String> set = new HashSet<>();
        for (String tuple : tuples) {
            if (!set.add(tuple)) {
                return false;
            }
        }
        return true;
    }

    private boolean minimality(String[][] relation, List<Integer> columnIndexes) {
        for (Integer columnIndex : columnIndexes) {
            List<String> tuples = new ArrayList<>();
            for (String[] row : relation) {
                StringBuilder sb = new StringBuilder();
                for (Integer index : columnIndexes) {
                    if (columnIndex != index) {
                        sb.append(row[columnIndex]);
                    }
                }
                tuples.add(sb.toString());
            }
            if (unique(tuples)) {
                return false;
            }
        }
        return true;
    }

}
