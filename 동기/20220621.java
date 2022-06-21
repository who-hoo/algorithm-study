public class Solution {
    
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        // AC ACDE BCFG CDE

        Solution s = new Solution();
        System.out.println(s.solution(orders, course));
    }

    private String[] solution(String[] orders, int[] course) {
        /**
         * 코스 요리 메뉴는 최소 2가지 이상의 단품 메뉴로 구성
         * 최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합
         * A, C...... A C
         */
        String[] answer = {};


        return answer;
    }

}
