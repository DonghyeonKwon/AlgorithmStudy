import java.util.*;

class Solution {

    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int curIdx = -1;
        int answer = 0;
        
        for(int[] arr : targets) {
            if(curIdx == -1) {
                answer++;
                curIdx = arr[1];
                continue;
            }
            
            if(arr[0] < curIdx) continue;
            
            answer++;
            curIdx = arr[1];
        }
        
        return answer;
    }

}