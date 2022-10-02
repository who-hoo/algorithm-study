import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        Map<String, String> recommenders = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-")) {
                recommenders.put(enroll[i], null);
            } else{
                recommenders.put(enroll[i], referral[i]);
            }
        }

        Map<String, Integer> profits = new HashMap<>();
        
        for (int i = 0; i < seller.length; i++) {
            distributeProfit(amount[i] * 100, seller[i], profits, recommenders);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profits.getOrDefault(enroll[i], 0);
        }
        return answer;
    }

    private void distributeProfit(int profit, String seller, Map<String, Integer> profits, Map<String, String> recommenders) {
        Integer raisedMoney = profits.getOrDefault(seller, 0);

        if (profit / 10 < 1) {
            profits.put(seller, raisedMoney + profit);
            return;
        }

        int forRecommender = profit / 10;
        profits.put(seller, raisedMoney + profit - profit / 10);

        if (recommenders.get(seller) == null) {
            return;
        }
        distributeProfit(forRecommender, recommenders.get(seller), profits, recommenders);

    }
}
