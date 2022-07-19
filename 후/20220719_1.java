import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int answer = Integer.MAX_VALUE;
	static int[][] stat;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		final int N = Integer.parseInt(in.readLine());
		stat = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			boolean[] startTeam = new boolean[N];
			select(startTeam, i, 0);
		}
		out.write(String.valueOf(answer));

		out.close();
		in.close();
	}

	public static void select(boolean[] starkTeam, int n, int starkTeamCount) {
		if (starkTeamCount == starkTeam.length / 2) {
			updateAnswer(starkTeam);
			return;
		}
		starkTeam[n] = true;
		for (int i = n + 1; i < starkTeam.length; i++) {
			if (!starkTeam[i]) {
				select(starkTeam, i, starkTeamCount + 1);
			}
		}
		starkTeam[n] = false;
	}

	public static void updateAnswer(boolean[] starkTeam) {
		int starkTeamStat = 0;
		int linkTeamStat = 0;
		for (int i = 0; i < starkTeam.length; i++) {
			for (int j = i; j < starkTeam.length; j++) {
				if (starkTeam[i] && starkTeam[j]) {
					starkTeamStat += (stat[i][j] + stat[j][i]);
				}
				if (!starkTeam[i] && !starkTeam[j]) {
					linkTeamStat += (stat[i][j] + stat[j][i]);
				}
			}
		}
		answer = Math.min(answer, Math.abs(starkTeamStat - linkTeamStat));
	}
}
