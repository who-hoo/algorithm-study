package programmers.lvl2.오픈채팅방;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        
    }
    
    public String[] solution(String[] records) {

        Map<String, String> nickName = new HashMap<>();
        List<String[]> temp = new ArrayList<>();

        for (int i = records.length - 1; i >= 0; i--) {
            String[] record = records[i].split(" ");
            if (record.length > 2) {
                nickName.putIfAbsent(record[1], record[2]);
            }
            if (!record[0].equals("Change")) {
                temp.add(record);
            }
        }

        Map<String, String> operation = Map.of("Enter", "들어왔습니다.", "Leave", "나갔습니다.");

        String[] answer = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            String[] record = temp.get(temp.size() - 1 - i);
            answer[i] = nickName.get(record[1]) + "님이 " + operation.get(record[0]);
        }

        return answer;
    }
}
