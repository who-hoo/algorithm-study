import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    static class File implements Comparable<File> {
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String getFileName() {
            return head + number + tail;
        }

        @Override
        public int compareTo(File o) {
            String fileHead = head.toUpperCase();
            String oFileHead = o.head.toUpperCase();
            if (!fileHead.equals(oFileHead)) {
                return fileHead.compareTo(oFileHead);
            }

            return Integer.parseInt(number) - Integer.parseInt(o.number);
        }
    }

    public String[] solution(String[] files) {

        List<File> data = new ArrayList<>();

        for (String file : files) {
            char[] f = file.toCharArray();

            StringBuilder head = new StringBuilder();
            int numberIndex = 0;
            for (int i = 0; i < f.length; i++) {
                if (f[i] < 48 || f[i] > 57) {
                    head.append(f[i]);
                } else {
                    numberIndex = i;
                    break;
                }
            }

            StringBuilder number = new StringBuilder();
            int tailIndex = 0;
            for (int i = numberIndex; i < f.length; i++) {
                if (f[i] > 47 && f[i] < 58) {
                    number.append(f[i]);
                    tailIndex = i + 1;
                } else {
                    tailIndex = i;
                    break;
                }
            }

            String tail = file.substring(tailIndex);

            data.add(new File(head.toString(), number.toString(), tail));
        }

        Collections.sort(data);

        String[] result = new String[files.length];

        int resultIndex = 0;
        for (File file : data) {
            result[resultIndex++] = file.getFileName();
        }

        return result;
    }
}
