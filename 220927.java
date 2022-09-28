import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        List<FileName> fileNames = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            FileName fileName = remakeFileName(files[i], i);
            fileNames.add(fileName);
        }

        Collections.sort(fileNames);
        return fileNames.stream()
            .map(e -> e.toString())
            .toArray(String[]::new);
    }

    private FileName remakeFileName(String file, int originalOrder) {
        String head = "";
        String number = "";
        String tail = "";
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                head = file.substring(0, i);
                int numberEnd = file.length() - 1;
                for (int j = i; j < file.length(); j++) {
                    if (!Character.isDigit(file.charAt(j))) {
                        number = file.substring(i, j);
                        tail = file.substring(j);
                        break;
                    }
                }
                break;
            }
        }
        return new FileName(head, number, tail);
    }
}

class FileName implements Comparable<FileName> {

    String head;
    String number;
    String tail;

    public FileName(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }

    @Override
    public int compareTo(FileName o) {
        if (this.head.compareToIgnoreCase(o.head) < 0) {
            return -1;
        } else if (this.head.compareToIgnoreCase(o.head) == 0) {
            if (Integer.parseInt(this.number) == Integer.parseInt(o.number)) {
                return 0;
            }
            return Integer.parseInt(this.number) - Integer.parseInt(o.number);
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return head + number + tail;
    }
}
