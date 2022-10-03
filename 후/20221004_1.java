import java.util.HashMap;

class Solution {
    final int priceOfToothBrush = 100;
    HashMap<String, Seller> sellers = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        initSellers(enroll, referral);
        for (int i = 0; i < seller.length; i++) {
            sellers.get(seller[i]).distributeProfit(priceOfToothBrush * amount[i]);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sellers.get(enroll[i]).profit;
        }
        return answer;
    }

    private void initSellers(String[] enroll, String[] referral) {
        for (String name : enroll) {
            sellers.put(name, new Seller(name));
        }
        for (int i = 0; i < referral.length; i++) {
            sellers.get(enroll[i]).referee = sellers.get(referral[i]);
        }
    }

    class Seller {

        String name;
        Seller referee;
        int profit;

        Seller(String name) {
            this.name = name;
        }

        void distributeProfit(int profit) {
            int commission = (int) (profit * 0.1);
            this.profit += profit - commission;
            if (referee != null) {
                referee.distributeProfit(commission);
            }
        }
    }
}
