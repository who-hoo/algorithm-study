import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 20220506 {
    public String[] solution(String[] record) {

        Map<String, String> userList = new HashMap<>();
        List<String[]> actions = new ArrayList<>();

        for (String r : record) {
            String[] splitRecord = r.split(" ");

            if (splitRecord[0].equals("Enter")) {
                userList.put(splitRecord[1], splitRecord[2]);
                actions.add(new String[]{splitRecord[0], splitRecord[1]});
            } else if (splitRecord[0].equals("Change")) {
                userList.put(splitRecord[1], splitRecord[2]);
            } else {
                actions.add(new String[]{splitRecord[0], splitRecord[1]});
            }
        }

        String[] answer = new String[actions.size()];

        for (int i = 0; i < actions.size(); i++) {
            String action = actions.get(i)[0];
            String id = actions.get(i)[1];
            if (action.equals("Enter")) {
                answer[i] = userList.get(id) + "님이 들어왔습니다.";
            } else {
                answer[i] = userList.get(id) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
