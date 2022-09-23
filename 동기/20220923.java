import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                String[] file1 = split(o1);
                String[] file2 = split(o2);

                int headValue = file1[0].compareTo(file2[0]);

                if (headValue == 0) {
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);

                    return num1 - num2;
                } else {
                    return headValue;
                }
            }
        });

        return files;
    }

    private String[] split(String file) {
        file = file.toLowerCase();
        int index = 0;
        for (char c : file.toCharArray()) {
            if (!(c >= '0' && c <= '9')) {
                index++;
            } else {
                break;
            }
        }

        String head = file.substring(0, index);
        file = file.substring(index);

        index = 0;
        for (char c : file.toCharArray()) {
            if (c >= '0' && c <= '9') {
                index++;
            } else {
                break;
            }
        }

        String number = file.substring(0, index);
        String tail = file.substring(index);
        return new String[]{head, number, tail};
    }
}
