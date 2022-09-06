import java.util.ArrayList;
import java.util.List;

public class Solution {
  
    List<ArrayList<Delivery>> deliveries;
  
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        deliveries = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            deliveries.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            deliveries.get(road[i][0]).add(new Delivery(road[i][1], road[i][2]));
        }

        return answer;
    }
  
    static class Delivery {

        int to;
        int cost;

        public Delivery(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
