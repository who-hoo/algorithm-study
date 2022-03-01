class Solution {
    public static int count = 0;

    public void dfs(int depth, int total, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (total == target) {
                count++;
            }
            return;
        } else {
            dfs(depth + 1, total + numbers[depth], numbers, target);
            dfs(depth + 1, total - numbers[depth], numbers, target);
        }
    }

    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return count;
    }
}
