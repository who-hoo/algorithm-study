class Solution {
    String target;
    int cnt;
    int result;

    public int solution(String word) {
        target = word;
        cnt = 1;
        dfs("A");
        dfs("E");
        dfs("I");
        dfs("O");
        dfs("U");

        return result;
    }

    public void dfs(String word) {
        if (word.length() > 5) {
            return;
        }

        if (target.equals(word)) {
            result = cnt;
            return;
        }

        cnt++;

        dfs(word.concat("A"));
        dfs(word.concat("E"));
        dfs(word.concat("I"));
        dfs(word.concat("O"));
        dfs(word.concat("U"));
    }
}
