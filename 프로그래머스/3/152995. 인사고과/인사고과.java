import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int n = scores[0][0];
        int m = scores[0][1];
        
        Arrays.sort(scores, (a, b) -> {
           if(a[0] == b[0]) {
               return a[1] - b[1];
           }
            return b[0] - a[0];
        });
        
        int len = scores.length;
        int max = scores[0][1];
        
        for(int i = 1; i < len; i++) {
            if(scores[i][1] < max) {
                if(scores[i][0] == n && scores[i][1] == m) return -1;
                
                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                max = scores[i][1];
            }
        }
        
        Arrays.sort(scores, (a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        
        int answer = 1;
        for(int i = 0 ; i < len; i++) {
            if(scores[i][0] + scores[i][1] > n + m) answer++;
            else break;
        }
        return answer;
    }
}