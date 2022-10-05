import java.util.HashMap;

class Report {

    int money;
    String referral;

    public Report(int money, String referral) {
        this.money = money;
        this.referral = referral;
    }
}

class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Report> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], new Report(0, referral[i]));
        }

        for (int i = 0; i < seller.length; i++) {
            String sell = seller[i];
            int money = amount[i] * 100;
            while (true) {
                if (map.get(sell).referral.equals("-")) {
                    map.get(sell).money += money - money / 10;
                    break;
                } else {
                    if (money < 10) {
                        map.get(sell).money += money;
                        break;
                    } else {
                        map.get(sell).money += money - money / 10;
                        money /= 10;
                        sell = map.get(sell).referral;
                    }
                }
            }
        }
      
        for (int i = 0; i < answer.length; i++) {
            answer[i] = map.get(enroll[i]).money;
        }
        return answer;
    }
}

