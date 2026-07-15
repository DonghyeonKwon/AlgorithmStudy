import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int work : works) {
            pq.add(work);
        }
        
        while(n > 0) {
            int tmp = pq.poll();
            if(tmp == 0) break;
            tmp--;
            n--;
            pq.add(tmp);
        }
        
        while(!pq.isEmpty()) {
            long tmp = pq.poll();
            answer += tmp * tmp;
        }
        
        return answer;
    }
}