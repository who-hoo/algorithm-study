import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		Set<String> store = new HashSet<>();

		for (int i = 0; i < n; i++) {
			store.add(br.readLine());
		}

		List<String> answer = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			String name = br.readLine();
			if (!store.add(name)) {
				answer.add(name);
			}
		}

		Collections.sort(answer);

		StringBuilder sb = new StringBuilder();

		sb.append(answer.size()).append('\n');

		for (String name : answer) {
			sb.append(name).append('\n');
		}

		System.out.println(sb);

	}

}
