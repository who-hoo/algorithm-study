package 아더;

import java.io.*;

public class BOJ_9251_LCS {

    static String S1, S2;
    static int[][] LCS;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        int answer = 0;

        for (int i = 0; i <= S1.length(); i++) {
            for (int j = 0; j <= S2.length(); j++) {
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                } else if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        for (int i = 0; i <= S1.length(); i++) {
            for (int j = 0; j <= S2.length(); j++) {
                answer = Math.max(answer , LCS[i][j]);
            }
        }

        System.out.println(answer);
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S1 = br.readLine();
        S2 = br.readLine();
        LCS = new int[S1.length() + 1][S2.length() + 1];
    }
}
