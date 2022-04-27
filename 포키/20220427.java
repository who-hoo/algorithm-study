class Solution {
    public int solution(String s) {
        int answer = 1000;
        int max = s.length() / 2;

        for (int i = 1; i < max; i++) {
            int count = 1;
            String current, next;
            String l = "";
            for (int j = 0; j < s.length()-i; j += i) {
                int mid = j + i;
                int end = j+(i*2) > s.length() ? s.length() : j+(i*2);
                current = s.substring(j, mid);
                next = s.substring(mid, end);

                boolean canCompress = current.equals(next);
                if (canCompress) {
                    count++;
                }else{
                    if (count == 1) {
                        l += current;
                    }else{
                        l += count + current;
                    }
                    count = 1;
                }
            }

            if (l.length() < answer) {
                answer = l.length();
            }
        }
        return answer;
    }
}
