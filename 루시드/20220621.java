public class Solution {

    static int answer;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(k, dungeons, 0);
        return answer;
    }

    private void dfs(int tired, int[][] dungeons, int cnt) {
        // [0] : 최소 필요 피로도, [1] : 소모 피로도
        // 피로도 소모하기
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > tired) continue;
            visited[i] = true;
            dfs(tired - dungeons[i][1], dungeons, cnt + 1);
            visited[i] = false;
        }

        answer = Math.max(answer, cnt);
    }
}
