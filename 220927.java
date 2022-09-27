package programmers.kakao.파일명_정렬;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] answer = solution.solution(
            new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF",
                "img2.JPG"});
//        System.out.println(answer);
//        solution.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
    }

    public String[] solution(String[] files) {
        String[] answer = {};
        //파일명을 세 부분으로 나눈 후, 다음 기준에 따라 파일명을 정렬한다.
        //파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다. 이때, 문자열 비교 시 대소문자 구분을 하지 않는다. MUZI와 muzi, MuZi는 정렬 시에 같은 순서로 취급된다.
        //파일명의 HEAD 부분이 대소문자 차이 외에는 같을 경우, NUMBER의 숫자 순으로 정렬한다. 9 < 10 < 0011 < 012 < 13 < 014 순으로 정렬된다. 숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값으로 처리된다.

        //얘를 어떻게 할까
        //두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지한다. MUZI01.zip과 muzi1.png가 입력으로 들어오면, 정렬 후에도 입력 시 주어진 두 파일의 순서가 바뀌어서는 안 된다.
        Map<Integer, String> originals = new HashMap<>();
        for (int i = 0; i < files.length; i++) {
            originals.put(i, files[i]);
            FileName fileName = remakeFileName(files[i], i);
        }

        return answer;
    }

    private FileName remakeFileName(String file, int originalOrder) {
        String head;
        String number;
        String tail;
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                head = file.substring(0, i).toLowerCase();
                int numberEnd = file.length() - 1;
                for (int j = i; j < file.length(); j++) {
                    if (!Character.isDigit(file.charAt(j))) {
                        numberEnd = j;
                    }
                    number = file.substring(i, numberEnd);
                    tail = file.substring(numberEnd);
                }
            }
        }
    }
}

class FileName implements Comparable{

    int originalOrder;
    String head;
    String number;
    String tail;

    public FileName(int originalOrder, String head, String number, String tail) {
        this.originalOrder = originalOrder;
        this.head = head;
        this.number = number;
        this.tail = tail;
    }

    @Override
    public int compareTo(Object o) {
        //만들어진 FileName을 출력 기준에 따라 정렬. 문자열이 같을 시 originalOrder를 이용해서 정렬하면 되지 않을까? 
        return 0;
    }
}
