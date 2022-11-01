package level3;

import java.util.LinkedHashMap;
import java.util.Map;

public class 다단계_칫솔팔기 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Seller> map = new LinkedHashMap<>();

        //직원 등록
        for (String s : enroll) {
            map.put(s, new Seller());
        }

        //관계 형성
        for (int i = 0; i < referral.length; i ++) {
            if (!referral[i].equals("-")) {
                map.get(enroll[i]).ref = map.get(referral[i]);
            }
        }

        //판매 금액 작성
        for (int i = 0; i < seller.length; i++) {
            Seller currentSeller = map.get(seller[i]);
            currentSeller.calculateAndGiveTax(amount[i] * 100);
        }

        return map.values().stream()
            .mapToInt(s -> s.profit)
            .toArray();
    }

    class Seller {

        private Seller ref;
        private int profit;

        public Seller() {
            this.ref = null;
            this.profit = 0;
        }

        public void calculateAndGiveTax(int amount) {
            this.profit += amount;
            int tax = (int) Math.floor(amount * 0.1);

            if (tax >= 1) {
                if (this.isEmployee()) {
                    this.profit -= tax;
                    this.ref.calculateAndGiveTax(tax);
                }else{
                    this.profit -= tax;
                }
            }
        }

        public boolean isEmployee() {
            return this.ref != null;
        }
    }

}

/*
자신의 이익에서 10프로를 상위 노드에게 지급 / 나머지는 자신이 가짐

enroll : 판매원 목록
referral : 추천인, 판매원
seller : 판 사람들
amount : 금액

 */