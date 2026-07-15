import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(n > s) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        int init = s / n;
        int mod = s % n;
        
        for(int i = 0; i < n; i++) {
            answer[i] = init;
        }
        
        int idx = n-1;
        for(int i = 0; i < mod; i++) {
            answer[idx]++;
            idx--;
        }
        
        return answer;
    }
}