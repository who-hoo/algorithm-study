import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    
    static final int COMMAND = 0;
    static final int ID = 1;
    static final int NICK_NAME = 2;
    static final String ENTER_MESSAGE = "들어왔습니다.";
    static final String LEAVE_MESSAGE = "나갔습니다.";
    static final HashMap<String, String> userMap = new HashMap<>();

    static class Log {

        String uid;
        String message;

        public Log(String uid, String message) {
            this.uid = uid;
            this.message = message;
        }

        @Override
        public String toString() {
            return userMap.get(uid) + "님이 " + message;
        }
    }

    public String[] solution(String[] record) {
        ArrayList<Log> logs = new ArrayList<>(record.length);
        for (String r : record) {
            String[] split = r.split(" ");
            if (split[COMMAND].equals("Enter")) {
                userMap.put(split[ID], split[NICK_NAME]);
                logs.add(new Log(split[ID], ENTER_MESSAGE));
            } else if (split[COMMAND].equals("Leave")) {
                logs.add(new Log(split[ID], LEAVE_MESSAGE));
            } else {
                userMap.put(split[ID], split[NICK_NAME]);
            }
        }
        String[] answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            answer[i] = logs.get(i).toString();
        }
        return answer;
    }
}
