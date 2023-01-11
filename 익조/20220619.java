class Solution {

    int result = 0;

    public int solution(int k, int[][] dungeons) {

        int countOfDungeons = dungeons.length;
        boolean[] visited = new boolean[countOfDungeons];

        hunt(dungeons, visited, 0, countOfDungeons, k, 0);

        return result;
    }

    private void hunt(int[][] dungeons, boolean[] visited, int depth, int countOfDungeons, int fatigue,
        int countOfHunt) {

        result = Math.max(result, countOfHunt);

        for (int i = 0; i < countOfDungeons; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                fatigue -= dungeons[i][1];
                countOfHunt++;

                hunt(dungeons, visited, depth + 1, countOfDungeons, fatigue, countOfHunt);

                fatigue += dungeons[i][1];
                countOfHunt--;
                visited[i] = false;
            }
        }
    }
}
