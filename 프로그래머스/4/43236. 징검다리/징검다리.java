import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(getRemovedRock(rocks, mid, distance) <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    int getRemovedRock(int[] rocks, int mid, int distance) {
        int start = 0;
        int end = distance;
        
        int cnt = 0;
        for(int i = 0; i < rocks.length; i++) {
            if(rocks[i] - start < mid) {
                cnt++;
                continue;
            }
            start = rocks[i];
        }
        
        if(end - start < mid) cnt++;
        
        return cnt;
    }
}