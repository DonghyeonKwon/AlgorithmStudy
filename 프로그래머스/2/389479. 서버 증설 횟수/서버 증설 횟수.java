import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int size = players.length;
        Queue<Integer> server = new ArrayDeque<>();
        
        for(int i = 0; i < size; i++) {
            while(!server.isEmpty() && server.peek() == i) {
                server.poll();
            }
            
            int n = server.size();
            if(n * m <= players[i] && players[i] < (n+1) * m) continue;
            else {
                int p = players[i] / m - n;
                while(p-- > 0) {
                    server.add(i + k);
                    answer++;
                }
            }
            
        }
        
        return answer;
    }
}