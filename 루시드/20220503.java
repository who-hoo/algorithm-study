import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[] solution(String s) {
        String substring = s.substring(2, s.length() - 2);

        List<List<Integer>> list = new ArrayList<>();

        String[] split = substring.split("(})(,)(\\{)");

        for (String tmp : split) {
            String[] numbers = tmp.split(",");
            List<Integer> integers = new ArrayList<>();
            for (String number : numbers) {
                integers.add(Integer.parseInt(number));
            }
            list.add(integers);
        }
        list.sort(Comparator.comparingInt(List::size));

        List<Integer> result = new ArrayList<>();
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                if (!result.contains(integer)) {
                    result.add(integer);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
