import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		final int N = Integer.parseInt(input[0]);
		final int M = Integer.parseInt(input[1]);
		Set<String> dm = new HashSet<>(N);
		int n = N;
		while(n-- > 0) {
			dm.add(br.readLine());
		}
		Set<String> bm = new HashSet<>(M);
		int m = M;
		while(m-- > 0) {
			bm.add(br.readLine());
		}

		List<String> answer = new ArrayList<>(Math.min(N,M));
		Set<String> bigger = (N >= M) ? dm : bm;
		Set<String> smaller = (N >= M) ? bm : dm;
		for (String s : smaller) {
			if (bigger.contains(s)) {
				answer.add(s);
			}
		}
		Collections.sort(answer);

		bw.write(answer.size() + "\n");
		for (String s : answer) {
			bw.write(s + "\n");
		}
		
		bw.close();
		br.close();
	}
}
