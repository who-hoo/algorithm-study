public class Solution {

    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int answer = 0;

    public int solution(int n, String[] data) {

        boolean[] visited = new boolean[8];

        dfs("", visited, data);

        return answer;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        Solution s = new Solution();
        int answer = s.solution(n, data);
        System.out.println(answer);
    }

    private void dfs(String names, boolean[] visited, String[] data) {
        // friends 는 8명인데 7도 되고 8도 되네
        if (names.length() == 8) {
//            System.out.println("names: " + names);
            if (check(names, data)) {
                answer++;
            }
            return;
        }

        // dfs
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String name = names + friends[i];
                dfs(name, visited, data);
                visited[i] = false;
            }
        }
    }

    private boolean check(String names, String[] data) {
        for (String d : data) {
            // 여기서 names.indexOf(d.charAt(0)) 가 무슨 역할을 하는거지
            int position1 = names.indexOf(d.charAt(0));

            System.out.println("position1: " + position1);
//            System.out.println("names: " + names);

            int position2 = names.indexOf(d.charAt(2));
//            System.out.println("position2: " + position2);

            char operation = d.charAt(3);
            int index = d.charAt(4) - '0';

            if (operation == '=') {
                // index 에 왜 1을 더해주는걸까
                // 여기서 !을 빼고 return true 를 해주면 예제와 같은 값이 나오지 않는다
                if (!(Math.abs(position1 - position2) == index + 1)) return false;
            } else if (operation == '>') {
                if (!(Math.abs(position1 - position2) > index + 1)) return false;
            } else if (operation == '<') {
                if (!(Math.abs(position1 - position2) < index + 1)) return false;
            }
        }
        return true;
    }
}
