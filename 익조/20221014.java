import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    int rowTotalCount, columnTotalCount;
    String[][] relation;
    Set<String> foreignKey = new HashSet<>();

    public int solution(String[][] relation) {
        this.relation = relation;

        rowTotalCount = relation.length;
        columnTotalCount = relation[0].length;

        boolean[] visited;

        for (int i = 1; i <= columnTotalCount; i++) {
            visited = new boolean[columnTotalCount];
            findForeignKey(0, 0, i, visited);
        }

        return foreignKey.size();
    }

    private void findForeignKey(int depth, int choiceCount, int columCount, boolean[] visited) {
        if (choiceCount == columCount) {
            verify(visited);
            return;
        }

        if (depth == columnTotalCount) {
            return;
        }

        visited[depth] = true;
        findForeignKey(depth + 1, choiceCount + 1, columCount, visited);
        visited[depth] = false;
        findForeignKey(depth + 1, choiceCount, columCount, visited);
    }

    private void verify(boolean[] visited) {
        StringBuilder preparatoryForeignKey = new StringBuilder();
        Set<String> duplicateBuffer = new HashSet<>();

        for (int i = 0; i < columnTotalCount; i++) {
            if (visited[i]) {
                preparatoryForeignKey.append(i);
            }
        }

        Set<Character> preparatoryForeignKeyElements = preparatoryForeignKey.chars().
            mapToObj(c -> (char) c)
            .collect(Collectors.toSet());

        for (String u : foreignKey) {
            Set<Character> foreignKeyElements = u.chars().
                mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

            if (preparatoryForeignKeyElements.containsAll(foreignKeyElements)) {
                return;
            }
        }

        StringBuilder columnData = new StringBuilder();

        for (int i = 0; i < rowTotalCount; i++) {
            for (int j = 0; j < columnTotalCount; j++) {
                if (visited[j]) {
                    columnData.append(relation[i][j]);
                }
            }

            String k = columnData.toString();

            if (duplicateBuffer.contains(k)) {
                return;
            }

            duplicateBuffer.add(k);
            columnData.setLength(0);
        }

        this.foreignKey.add(preparatoryForeignKey.toString());
    }
}
