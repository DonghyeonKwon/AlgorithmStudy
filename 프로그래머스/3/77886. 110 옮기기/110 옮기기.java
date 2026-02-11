import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int t = 0; t < s.length; t++) {
            if(s[t].length() <= 3) {
                answer[t] = s[t];
                continue;
            }
            
            int one = 0;
            int ooz = 0;
            Stack<Character> stk = new Stack<>();
            char[] arr = s[t].toCharArray();
            int len = arr.length;
            for(int i = 0; i < len; i++) {
                if(arr[i] == '1') {
                    stk.push(arr[i]);
                    one++;
                } else {
                    if(one >= 2) {
                        stk.pop();
                        stk.pop();
                        one -= 2;
                        ooz++;
                    } else {
                        one = 0;
                        stk.push(arr[i]);
                    }
                }
            }
            
            int pos = -1;
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while(!stk.isEmpty()) {
                char c = stk.pop();
                sb.append(c);
                if(pos == -1 && c == '0') pos = idx;
                idx++;
            }
            
            sb.reverse();
            
            if(pos == -1) {
                answer[t] = "110".repeat(ooz) + sb;
            } else {
                pos = idx - pos - 1;
                answer[t] = sb.substring(0, pos+1) + "110".repeat(ooz) + sb.substring(pos + 1);
            }
            
        }
        return answer;
    }
}