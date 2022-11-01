class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) continue;
                map[i][j] = 500001;
            }
        }

        for (int[] r : road) {
            int start = r[0];
            int end = r[1];
            int distance = r[2];

            if(map[start][end] < distance) continue;
            map[start][end] = distance;
            map[end][start] = distance;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                for(int k=1; k<=N; k++) {
                    if(map[j][k] > map[j][i] + map[i][k])
                        map[j][k] = map[j][i] + map[i][k];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (map[1][i] <= K)
                answer++;
        }

        return answer;
    }

}