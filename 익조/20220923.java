class Solution {

    public int solution(int[][] triangle) {
        int[][] memo = new int[triangle.length][triangle.length];
        memo[0][0] = triangle[0][0];
        memo[1][0] = memo[0][0] + triangle[1][0];
        memo[1][1] = memo[0][0] + triangle[1][1];

        for (int i = 2; i < triangle.length; i++) {
            memo[i][0] = memo[i - 1][0] + triangle[i][0];
            memo[i][i] = memo[i - 1][i - 1] + triangle[i][i];
            for (int j = 1; j < triangle[i].length; j++) {
                memo[i][j] = Math.max(memo[i - 1][j - 1] + triangle[i][j], memo[i - 1][j] + triangle[i][j]);
            }
        }

        int result = 0;
        for (int i = 0; i < triangle.length; i++) {
            result = Math.max(result, memo[triangle.length - 1][i]);
        }

        return result;
    }
}
