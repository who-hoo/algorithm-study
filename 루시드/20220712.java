// [루시드] 20220712 프로그래머스 단체사진찍기 풀이 제출
class Solution {

    static char[] character = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] check = new boolean[8];
    StringBuilder sb = new StringBuilder();
    String[] save;
    int result = 0;

    public int solution(int n, String[] data) {
        save = data;
        DFS(0);
        return result;
    }

    private void DFS(int L) {
        if (L == 8) {
            for (String s : save) {
                String tmp1 = String.valueOf(s.charAt(0));
                String tmp2 = String.valueOf(s.charAt(2));
                String comp = String.valueOf(s.charAt(3));
                int value = Character.getNumericValue(s.charAt(4));

                int a = sb.indexOf(tmp1);
                int b = sb.indexOf(tmp2);

                if (comp.equals("=")) {
                    if (Math.abs(a - b) - 1 != value) {
                        return;
                    }
                }
                if (comp.equals(">")) {
                    if (!(Math.abs(a - b) - 1 > value)) {
                        return;
                    }
                }
                if (comp.equals("<")) {
                    if (!(Math.abs(a - b) - 1 < value)) {
                        return;
                    }
                }
            }
            result++;
        }

        for (int i = 0; i < character.length; i++) {
            if (!check[i]) {
                check[i] = true;
                sb.append(character[i]);
                DFS(L + 1);
                sb.deleteCharAt(L);
                check[i] = false;
            }
        }
    }
}
