package 아더;

import java.util.Arrays;
import java.util.HashMap;

public class PRO_77486_다단계칫솔판매 {

    public static void main(String[] args) {
        PRO_77486_다단계칫솔판매 pro = new PRO_77486_다단계칫솔판매();

        String[][] enroll = {
            {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
            {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
        };
        String[][] referral = {
            {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
            {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
        };
        String[][] seller = {
            {"young", "john", "tod", "emily", "mary"},
            {"sam", "emily", "jaimie", "edward"}
        };
        int[][] amount = {
            {12, 4, 2, 5, 10},
            {2, 3, 5, 4}
        };

        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(pro.solution(enroll[i], referral[i], seller[i], amount[i])));
        }
    }

    class Person {

        private String name;
        private Person parent;
        private int profit;

        public Person(String name) {
            this.name = name;
            this.parent = null;
            this.profit = 0;
        }

        public void setParent(Person parent) {
            this.parent = parent;
        }

        public int getProfit() {
            return profit;
        }

        public void calculateProfit(int profit) {
            int profitToParent = profit / 10;
            this.profit += profit - profitToParent;
            if (this.parent != null && profitToParent >= 1) {
                this.parent.calculateProfit(profitToParent);
            }
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int enrollLength = enroll.length;
        int sellerLength = seller.length;
        HashMap<String, Person> persons = new HashMap<>();

        // enroll 만큼 반복하기
        for (String en : enroll) {
            persons.put(en, new Person(en));
        }

        // referral과 enroll 연결하기
        for (int i = 0; i < enrollLength; i++) {
            if (referral[i].equals("-")) {
                continue;
            }
            Person person = persons.get(enroll[i]);
            person.setParent(persons.get(referral[i]));
        }

        for (int i = 0; i < sellerLength; i++) {
            persons.get(seller[i]).calculateProfit(amount[i] * 100);
        }

        return Arrays.stream(enroll)
            .mapToInt(en -> persons.get(en).getProfit())
            .toArray();
    }

}
