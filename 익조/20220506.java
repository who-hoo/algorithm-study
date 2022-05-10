import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    Map<String, String> nickNamesById = new HashMap<>();

    static class UserStatue {

        String userId;
        String statue;

        UserStatue(String userId, String statue) {
            this.userId = userId;
            this.statue = statue;
        }

        boolean isEnter() {
            return statue.equals("Enter");
        }

        boolean isLeave() {
            return statue.equals("Leave");
        }
    }

    public String[] solution(String[] record) {

        List<UserStatue> userStatues = new ArrayList<>();

        for (String logsOfUser : record) {
            String[] data = logsOfUser.split(" ");
            String statue = data[0];
            String userId = data[1];

            UserStatue userStatue;

            switch (statue) {
                case "Enter" -> {
                    String nickName = data[2];
                    nickNamesById.put(userId, nickName);
                    userStatue = new UserStatue(userId, statue);
                    userStatues.add(userStatue);
                }
                case "Change" -> {
                    String nickName = data[2];
                    nickNamesById.put(userId, nickName);
                }
                case "Leave" -> {
                    userStatue = new UserStatue(userId, statue);
                    userStatues.add(userStatue);
                }

            }

        }

        return getResult(userStatues);
    }

    private String[] getResult(List<UserStatue> userStatues) {
        String[] result = new String[userStatues.size()];

        int i = 0;
        for (UserStatue userStatue : userStatues) {
            if (userStatue.isEnter()) {
                result[i++] = nickNamesById.get(userStatue.userId) + "님이 들어왔습니다.";
            }
            else if (userStatue.isLeave()) {
                result[i++] = nickNamesById.get(userStatue.userId) + "님이 나갔습니다.";
            }
        }

        return result;
    }
}
