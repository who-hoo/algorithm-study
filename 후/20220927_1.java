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
        private String tail;

        File(String filename) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();

            int i = 0;
            while (!Character.isDigit(filename.charAt(i))) {
                head.append(filename.charAt(i++));
            }
            while (Character.isDigit(filename.charAt(i)) && number.length() <= 5) {
                number.append(filename.charAt(i++));
            }
            if (i < filename.length()) {
                tail.append(filename.substring(i));
            }

            this.head = head.toString();
            this.number = number.toString();
            this.tail = tail.toString();
        }

        @Override
        public String toString() {
            return head + number + tail;
        }

        @Override
        public int compareTo(File o) {
            // 1. HEAD를 기준으로 사전 순(대소문자 구분 x)
            int result = this.head.compareToIgnoreCase(o.head);
            if (result != 0) {
                return result;
            }
            // 2. NUMBER의 숫자 순으로(숫자 앞의 0은 무시)
            result = Integer.parseInt(this.number) - Integer.parseInt(o.number);
            // 3. 원래 입력에 주어진 순서 유지
            return result;
        }
    }
}
