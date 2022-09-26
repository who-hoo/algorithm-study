import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 파일명정렬 {
    public String[] solution(String[] files) {


        List<File> fileList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            int index = 0;
            for (int j = 0; j < file.length(); j++) {
                if (!Character.isDigit(file.charAt(j))) {
                    head.append(file.charAt(j));
                } else {
                    index = j;
                    break;
                }
            }

            for (int j = index; j < file.length(); j++) {
                if (!Character.isDigit(file.charAt(j)) || number.length() == 5) {
                    index = j;
                    break;
                }
                if (j == file.length() - 1) {
                    index = file.length();
                }
                number.append(file.charAt(j));
            }

            tail.append(file.substring(index));
            fileList.add(new File(i, head.toString(), number.toString(), tail.toString()));
        }

        Collections.sort(fileList);

        String[] answer = new String[fileList.size()];
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).getString();
        }
        return answer;
    }

    class File implements Comparable<File>{

        int index;
        String head;
        String number;
        String tail;

        public File(int index, String head, String number, String tail) {
            this.index = index;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public int getIndex() {
            return index;
        }

        public String getHead() {
            return head.toUpperCase();
        }

        public int getNumber() {
            return Integer.parseInt(number);
        }

        public String getString() {
            return head + number + tail;
        }

        @Override
        public int compareTo(File file) {
            if (!this.getHead().equals(file.getHead())) {
                return this.getHead().compareTo(file.getHead());
            }else if(this.getNumber() != file.getNumber()){
                return this.getNumber() > file.getNumber() ? 1 : -1;
            }else{
                return this.getIndex() > file.getIndex() ? 1 : -1;
            }

        }
    }
}