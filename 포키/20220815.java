import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9521 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] word1 = br.readLine().split("");
        String[] word2 = br.readLine().split("");

        int[][] lcs = new int[word1.length+1][word2.length+1];

        int result = 0;
        for (int i = 1; i <= word1.length; i++) {
            String w1 = word1[i-1];
            for (int j = 1; j <= word2.length; j++) {
                String w2 = word2[j-1];
                if (w1.equals(w2)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
                result = Math.max(result, lcs[i][j]);
            }
        }
        System.out.println(result);
    }
}
