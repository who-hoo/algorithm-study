import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    Map<String, Integer> countByMenuCombination = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {

        List<String> result = new ArrayList<>();

        for (int sizeOfCourse : course) {
            for (String order : orders) {
                String[] menus = order.split("");
                boolean[] choicesOfMenu = new boolean[menus.length];
                Arrays.sort(menus);
                dfs(0, 0, sizeOfCourse, menus, choicesOfMenu);
            }

            int maxCountOfOrder = countByMenuCombination.keySet().stream()
                .filter(menuCombination -> menuCombination.length() == sizeOfCourse)
                .map(menuCombination -> countByMenuCombination.get(menuCombination))
                .filter(count -> count > 1).mapToInt(x -> x)
                .max().orElse(0);
            result.addAll(
                countByMenuCombination.keySet().stream()
                    .filter(menuCombination -> menuCombination.length() == sizeOfCourse && countByMenuCombination.get(menuCombination) == maxCountOfOrder)
                    .collect(Collectors.toList())
            );
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    public void dfs(int depth, int cnt, int sizeOfCourse, String[] menus, boolean[] choicesOfMenu) {
        if (cnt == sizeOfCourse) {
            String menuCombination = getMenuCombination(menus, choicesOfMenu);
            countByMenuCombination.put(menuCombination, countByMenuCombination.getOrDefault(menuCombination, 0) + 1);
            return;
        }

        if (depth == menus.length) {
            return;
        }

        choicesOfMenu[depth] = true;
        dfs(depth + 1, cnt + 1, sizeOfCourse, menus, choicesOfMenu);
        choicesOfMenu[depth] = false;
        dfs(depth + 1, cnt, sizeOfCourse, menus, choicesOfMenu);
    }

    public String getMenuCombination(String[] menus, boolean[] visited) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < menus.length; i++) {
            if (visited[i]) {
                sb.append(menus[i]);
            }
        }

        return sb.toString();
    }
  
