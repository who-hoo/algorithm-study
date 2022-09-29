package 아더;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class PRO_17686_파일명정렬 {

    public static void main(String[] args) {
        PRO_17686_파일명정렬 pro = new PRO_17686_파일명정렬();

        String[][] files = {
            {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"},
            {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"},
            {"a99999b", "A99998b"}
        };

        for (String[] file : files) {
            System.out.println(Arrays.toString(pro.solution(file)));
        }
    }

    class File implements Comparable<File>{
        private String head;
        private int number;
        private String originalFileName;

        private File() {}

        public File(String fileName) {
            String[] fileNameSplits = splitFileName(fileName);

            this.head = fileNameSplits[0].toLowerCase();
            this.number = Integer.parseInt(fileNameSplits[1]);
            this.originalFileName = fileName;
        }

        private String[] splitFileName(String fileName) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();

            for (char ch : fileName.toCharArray()) {
                if (!Character.isDigit(ch) && number.length() == 0) {
                    head.append(ch);
                    continue;
                }
                if (Character.isDigit(ch) && number.length() < 6) {
                    number.append(ch);
                    continue;
                }
                break;
            }

            return new String[]{head.toString(), number.toString()};
        }

        public String getOriginalFileName() {
            return this.originalFileName;
        }

        @Override
        public int compareTo(File o) {
            if (this.head.equals(o.head)) {
                return this.number - o.number;
            }
            return this.head.compareTo(o.head);
        }
    }

    public String[] solution(String[] files) {
        List<File> fileLists = new ArrayList<>();
        for (String fileName : files) {
            fileLists.add(new File(fileName));
        }

        Collections.sort(fileLists);

        return fileLists.stream()
            .map(File::getOriginalFileName)
            .toArray(String[]::new);
    }
}
