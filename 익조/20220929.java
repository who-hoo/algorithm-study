import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<String, String> parentBySeller = new HashMap<>();
    Map<String, Integer> earningsBySeller = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            parentBySeller.put(enroll[i], referral[i].equals("-") ? "center" : referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            distribute(seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = earningsBySeller.getOrDefault(enroll[i], 0);
        }

        return answer;
    }

    private void distribute(String seller, int amount) {
        int fee = amount / 10;
        if (fee == 0) {
            earningsBySeller.put(seller, earningsBySeller.getOrDefault(seller, 0) + amount);
        } else {
            if (parentBySeller.containsKey(seller)) {
                earningsBySeller.put(seller, earningsBySeller.getOrDefault(seller, 0) + amount - fee);
                String parent = parentBySeller.get(seller);
                distribute(parent, fee);
            } else {
                earningsBySeller.put(seller, earningsBySeller.getOrDefault(seller, 0) + amount);
            }
        }
    }
}
