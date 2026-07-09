import java.util.*;

class Solution {
    int answer = 0, min = Integer.MAX_VALUE;
    
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        
        int l = 0, r = 0;
        int cnt = 0;
        while(l < list.size()) {
            while(cnt < k && r < list.size()) {
                cnt += list.get(r++);
            }
            
            if(cnt > k) {
                if(list.get(r-1) - (cnt - k) > 0) {
                    if(min > r - l) {
                        min = r - l;
                    }
                }
            } else if(cnt == k) {
                if(min > r - l) {
                    min = r - l;
                }
            }
            
            cnt -= list.get(l);
            l++;
        }
        
        return min;
    }
}