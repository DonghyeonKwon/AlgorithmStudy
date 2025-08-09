import java.util.*;

class Solution {
    
    public int solution(int coin, int[] cards) {
        int len = cards.length;
        int answer = 0;
        
        Set<Integer> original, additional;
        original = new HashSet<>();
        additional = new HashSet<>();
        
        int idx = len/3;
        int target = len + 1;
        for(int i = 0; i < idx; i++) {
            original.add(cards[i]);
        }
        
        while(true) {
            answer++;
            
            if(idx >= len){
                break;
            }
            
            boolean flag = false;
            additional.add(cards[idx]);
            additional.add(cards[idx+1]);
            
            idx += 2;
            
            for(int i : original) {
                if(original.contains(target - i)) {
                    original.remove(i);
                    original.remove(target - i);
                    flag = true;
                    break;
                }
            }
            
            if(!flag) {
                if(coin > 0) {
                    for(int i : original) {
                        if(additional.contains(target - i)) {
                            original.remove(i);
                            additional.remove(target - i);
                            coin--;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            if(!flag) {
                if(coin > 1) {
                    for(int i : additional) {
                        if(additional.contains(target - i)) {
                            additional.remove(i);
                            additional.remove(target - i);
                            coin--;
                            coin--;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            if(!flag) break;
        }
        
        return answer;
    }
}