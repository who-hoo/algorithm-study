import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 듣도 못한 사람의 수를 저장해서 보도 못한 사람의 수가 입력될 때 듣도 못한 사람의 수와 비교하여 있으면 출력하기 위해 저장한다
	 *
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());	// 듣도 못한 사람의 수 N
		int M = Integer.parseInt(st.nextToken());	// 보도 못한 사람의 수 M

		Set<String> arr = new HashSet<>();
		for (int i = 0; i < N; i++) {
			arr.add(br.readLine());
		}

		List<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (arr.contains(s)) {
				list.add(s);
			}
		}

		System.out.println(list.size());
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
