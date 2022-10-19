import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    private String[][] relation;
    private final List<String> indexList = new LinkedList<>();

    public int solution(String[][] relation) {
        this.relation = relation;

        String[] arr = new String[relation[0].length];
        for(int i=0; i<relation[0].length; i++)
            arr[i] = Integer.toString(i);

        for (int i = 1; i <= relation[0].length; i++)
            combination(arr, new boolean[relation[0].length], 0, i);

        return indexList.size();
    }

    public void combination(String[] arr, boolean[] check, int index, int r) {
        if (r == 0) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (check[i])
                    result.append(arr[i]);
            }

            for (String sub : indexList) {
                int count = 0;
                for (int i = 0; i < sub.split("").length; i++) {
                    if(result.toString().contains(String.valueOf(sub.charAt(i))))
                        count++;
                }

                if (sub.length() == count)
                    return;
            }

            if (dupleCheck(result.toString()))
                indexList.add(result.toString());
        } else {
            for (int i = index; i < arr.length; i++) {
                check[i] = true;
                combination(arr, check, i + 1, r - 1);
                check[i] = false;
            }
        }
    }

    public boolean dupleCheck(String index) {
        Set<String> set = new HashSet<>();

        for (String[] strings : relation) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < index.split("").length; j++) {
                builder.append(strings[Integer.parseInt(String.valueOf(index.charAt(j)))]);
                builder.append("/");
            }

            if (set.contains(builder.toString()))
                return false;
            else
                set.add(builder.toString());
        }

        return true;
    }
}
