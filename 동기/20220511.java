import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

	private static int COMMAND = 0;
	private static int ID = 1;
	private static int NICKNAME = 2;

	public String[] solution(String[] record) {
		Map<String, String> map = new HashMap<>();
		List<String> arr = new ArrayList<>();

		for (String r : record) {
			String[] split = r.split(" ");

			if (split[COMMAND].equals("Enter")) {
				map.put(split[ID], split[NICKNAME]);
				arr.add(split[ID] + "님이 들어왔습니다.");
			} else if (split[COMMAND].equals("Leave")) {
				arr.add(split[ID] + "님이 나갔습니다.");
			} else if (split[COMMAND].equals("Change")) {
				map.put(split[ID], split[NICKNAME]);
			}
		}

		String[] answer = new String[arr.size()];

		for (int i = 0; i < arr.size(); i++) {
			int index = arr.get(i).indexOf("님");
			String id = arr.get(i).substring(0, index);
			String currentNickname = map.get(id);

			answer[i] = currentNickname + arr.get(i).substring(index);
		}


		return answer;
	}

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

		Solution2 s = new Solution2();
		System.out.println(Arrays.toString(s.solution(record)));
	}

}
