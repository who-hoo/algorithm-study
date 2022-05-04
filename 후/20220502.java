import java.util.*;

class Solution {

    class Element implements Comparable<Element> {

        int n;
        int count;

        Element(int n) {
            this.n = n;
            this.count = 1;
        }

        void addCount() {
            this.count++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Element element = (Element) o;
            return n == element.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n);
        }

        @Override
        public int compareTo(Element o) {
            if (count > o.count) {
                return -1;
            } else if (count == o.count) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public int[] solution(String s) {
        s = replacing(s);
        String[] split = s.split(",");
        HashSet<Element> set = new HashSet<>();
        ArrayList<Element> elements = new ArrayList<>();
        for (String str : split) {
            Element e = new Element(Integer.parseInt(str));
            if (set.add(e)) {
                elements.add(e);
            } else {
                int i = elements.indexOf(e);
                elements.get(i).addCount();
            }
        }
        Collections.sort(elements);
        return elements.stream()
            .map(e -> e.n)
            .mapToInt(Integer::intValue)
            .toArray();
    }

    private String replacing(String s) {
        s = s.replace('{', ' ');
        s = s.replace('}', ' ');
        s = s.replace(" ", "");
        return s;
    }
}
