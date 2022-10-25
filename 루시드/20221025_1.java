import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    static int[] dx = {0, 1, 0, -1}; // u, r, d, l
    static int[] dy = {1, 0, -1, 0};
    static Map<Character, Integer> map = new HashMap<>();

    public int solution(String dirs) {
        map.put('U', 0);
        map.put('R', 1);
        map.put('D', 2);
        map.put('L', 3);

        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;

        for (char now : dirs.toCharArray()) {
            Integer idx = map.get(now);
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            // out of bound면 무시
            if (nx > 5 || nx < -5 || ny > 5 || ny < -5) continue;

            // 해당 루트가 존재하지 않았을 경우에만 set에 넣기
            String dir = x + "" + y + "" + nx + "" + ny;
            String nDir = nx + "" + ny + "" + x + "" + y;

            if (!visited.contains(dir) && !visited.contains(nDir)) {
                visited.add(dir);
                visited.add(nDir);
            }

            x = nx;
            y = ny;
        }
        return visited.size() / 2;
    }
}
