import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstString = br.readLine();
        String secondString = br.readLine();

        Solution s = new Solution();
        System.out.println(s.solution(firstString, secondString));
    }

    public int solution(String firstString, String secondString) {
        String[] split = firstString.split("");
        String[] split1 = secondString.split("");
        int[][] lcs = new int[split.length + 1][split1.length + 1];
        for (int i = 1; i <= split.length; i++) {
            for (int j = 1; j <= split1.length; j++) {
                if (split[i - 1].equals(split1[j - 1])) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[split.length][split1.length];
    }
}
