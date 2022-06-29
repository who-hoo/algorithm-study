import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static boolean[][] network;
	static boolean[] checked;
	static Stack<Integer> stack = new Stack<>();
	static int answer = 0;

	static void dfs() {
		while (!stack.isEmpty()) {
			int n = stack.pop();
			for (int i = 1; i < network.length; i++) {
				if (network[n][i] && !checked[i]) {
					checked[i] = true;
					stack.push(i);
					answer++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalComputerCnt = Integer.parseInt(br.readLine());
		int pairCnt = Integer.parseInt(br.readLine());
		network = new boolean[totalComputerCnt + 1][totalComputerCnt + 1];
		checked = new boolean[totalComputerCnt + 1];
		while (pairCnt-- > 0) {
			String[] computers = br.readLine().split(" ");
			int aComputer = Integer.parseInt(computers[0]);
			int bComputer = Integer.parseInt(computers[1]);
			network[aComputer][bComputer] = true;
			network[bComputer][aComputer] = true;
		}

		checked[1] = true;
		stack.push(1);
		dfs();

		System.out.println(answer);
	}
}
