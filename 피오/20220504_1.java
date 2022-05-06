package programmers.lvl2.튜플;

import java.util.*;

public class Solution {
    public int[] solution(String s) {
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        String[] nums = s.split("\\},\\{");

        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            elements.add(new Element(nums[i].split(",")));
        }
        Collections.sort(elements);
        Set answerSet = new LinkedHashSet();
        for (Element element : elements) {
            String[] elem = element.getElement();
            for (int i = 0; i < elem.length; i++) {
                answerSet.add(Integer.parseInt(elem[i]));
            }
        }
        return answerSet.stream().mapToInt(e -> (int) e).toArray();

    }
}

class Element implements Comparable<Element> {

    String[] element;

    public Element(String[] element) {
        this.element = element;
    }

    public String[] getElement() {
        return element;
    }

    @Override
    public int compareTo(Element o) {
        return this.element.length - o.element.length;
    }
}
