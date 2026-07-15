import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int cam = -40000;

        for(int[] car : routes) {
            if(cam < car[0]) {
                cam = car[1];
                answer++;
            }
        }
        
        return answer;
    }
}