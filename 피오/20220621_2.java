class Solution {
    
    public int answer = 0;
    public boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);
        return answer;
    }

    public void dfs(int stage, int k, int[][] dungeons) {

        answer = Math.max(stage, answer);

        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                dfs(stage + 1, k - dungeons[i][1], dungeons);
                visited[i] = false; //앞선 dfs가 다 끝난 후 다음 dfs가 진행될 수 있도록 방문처리했던 곳을 해제함.
            }
        }
    }
}
