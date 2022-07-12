import java.util.ArrayList;
import java.util.List;

class Solution {

    String[] characters = {"A", "C", "F", "J", "M", "N", "R", "T"};
    List<Condition> conditions = new ArrayList<>();
    List<String> characterList = new ArrayList<>();

    int result = 0;

    static class Condition {

        String subject;
        String object;
        String operation;
        int gap;

        public Condition(String data) {
            this.subject = String.valueOf(data.charAt(0));
            this.object = String.valueOf(data.charAt(2));
            this.operation = String.valueOf(data.charAt(3));
            this.gap = data.charAt(4) - 47;
        }

        public boolean validate(List<String> position) {
            int subjectIndex = position.indexOf(subject);
            int objectIndex = position.indexOf(object);
            if (operation.equals(">")) {
                return Math.abs(subjectIndex - objectIndex) > gap;
            }
            else if (operation.equals("=")) {
                return Math.abs(subjectIndex - objectIndex) == gap;
            }
            else {
                return Math.abs(subjectIndex - objectIndex) < gap;
            }
        }
    }

    public int solution(int n, String[] data) {
        for (String d : data) {
            conditions.add(new Condition(d));
        }

        boolean[] visited = new boolean[8];

        lineUp(visited, 0);

        return result;
    }

    private void lineUp(boolean[] visited, int depth) {
        if (depth == 8) {
            boolean flag = true;
            for (Condition condition : conditions) {
                if (!condition.validate(characterList)) {
                    flag = false;
                    break;
                }
            }
            if (flag) result++;

            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                depth++;
                characterList.add(characters[i]);

                lineUp(visited, depth);

                characterList.remove(characters[i]);
                depth--;
                visited[i] = false;
            }
        }
    }
}
