import java.util.LinkedList;

public class Solution {
    // 두 큐의 합이 같게 만들어야함
    // 안 되는 경우에는 -1 반환
    // 큐이기 때문에
    // dfs? bfs?
    // 3, 2, 7, 2
    // 4, 6, 5, 1

    // 필요한 기능이 뭐가 있을까
    // 일단 두 큐의 합을 알아야 하니까, 두 배열의 원소 총 합을 구하는 로직

    // 정수 배열을 큐에다 각각 넣어서 로직 수행
    // 두 큐의 합을 구하고 sum1, sum2를 비교하면서 같아질 때까지 원소를 빼고 넣고하는 작업 수행
    // sum1 값이 더 작다면 sum2의 원소를 빼서 sum2에 넣어준다

    // 두 큐의 합이 같아질 수 없을 때의 로직
    //

    public int solution(int[] queue1, int[] queue2) {
        int result = -2;
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        int sum1 = 0;
        int sum2 = 0;
        // 정수 배열을 queue에다 넣으면서 각 정수 배열의 합을 구한다
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        while (sum1 != sum2) {
            // 2가 더 작다면 1에서 원소를 가져와야함
            if (sum1 > sum2) {

            }
        }




        return result;
    }
}
