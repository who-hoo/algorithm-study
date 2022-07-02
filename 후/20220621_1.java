class Solution {
	boolean[] visited;
	int hp;
	int count = 0;
	int answer = 0;

	void explore(int idx, int[][] dungeons) {
		visited[idx] = true;
		hp -= dungeons[idx][1];
		count++;
		answer = Math.max(answer, count);
		for (int next = 0; next < dungeons.length; next++) {
			if (!visited[next] && hp >= dungeons[next][0]) {
				explore(next, dungeons);
			}
		}
		visited[idx] = false;
		hp += dungeons[idx][1];
		count--;
	}

	public int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		hp = k;
		for (int i = 0; i < dungeons.length; i++) {
			if (hp >= dungeons[i][0]) {
				explore(i, dungeons);
			}
		}
		return answer;
	}
}
