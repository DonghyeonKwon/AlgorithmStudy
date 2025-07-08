import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        
        Arrays.sort(bans, (o1, o2) -> {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });
        
        Queue<String> queue = new ArrayDeque<>();
        for(String str : bans) {
            queue.offer(str);
        }
        
        while(!queue.isEmpty()) {
            String cur = queue.peek();
            String str = getString(n);
            
            if(cur.length() < str.length() || (cur.length() == str.length() && cur.compareTo(str) <= 0)){
                n++;
                queue.poll();
            } else {
                break;
            }
        }
        
        return getString(n);
    }
    
    String getString(long n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            int remained = (int)(n % 26);
            n /= 26;
            if(remained == 0) {
                n--;
                sb.append('z');
            } else {
                sb.append((char)('a' + remained - 1));
            }
        }
        
        return sb.reverse().toString();
    }
}