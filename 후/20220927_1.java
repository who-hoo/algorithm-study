import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>(files.length);
        for (String filename : files) {
            fileList.add(new File(filename));
        }

        return fileList.stream()
            .sorted()
            .map(File::toString)
            .toArray(String[]::new);
    }

    class File implements Comparable<File> {

        private String head;
        private String number;
        private String filename;

        File(String filename) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();

            for (char ch : filename.toCharArray()) {
                if (!Character.isDigit(ch) && number.length() == 0) {
                    head.append(ch);
                    continue;
                }
                if (Character.isDigit(ch) && number.length() <= 5) {
                    number.append(ch);
                    continue;
                }
                break;
            }

            this.head = head.toString();
            this.number = number.toString();
            this.filename = filename;
        }

        @Override
        public String toString() {
            return filename;
        }

        @Override
        public int compareTo(File o) {
            if (this.head.equalsIgnoreCase(o.head)) {
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            }
            return this.head.compareToIgnoreCase(o.head);
        }
    }
}
