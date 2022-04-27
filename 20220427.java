public class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        int repeat = s.length() / 2;
        int L = s.length();
        
        if(s.length() == 1) {
            return answer = 1;
        }

        for(int i=0; i<repeat; i++) {
            int idx = 0;
            int size = i+1;
            StringBuilder sb = new StringBuilder();
            String tmp1 = s.substring(0, size);
            int cnt = 1;

            while(true) {
                idx += size;
                if(L-idx >= size) {
                    String tmp2 = s.substring(idx, idx + size);
                    if(tmp1.equals(tmp2)) {
                        cnt++;
                        continue;
                    }
                    //앞과 다를 경우,
                    if(cnt > 1) {
                        sb.append(cnt).append(tmp1);
                        cnt = 1;
                        tmp1 = tmp2;
                        continue;
                    } else {
                        sb.append(tmp1);
                        cnt = 1;
                        tmp1 = tmp2;
                        continue;
                    }
                }
                if(cnt > 1) {
                    sb.append(cnt);
                }
                sb.append(s.substring(idx - size, L));
                break;
            }
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
