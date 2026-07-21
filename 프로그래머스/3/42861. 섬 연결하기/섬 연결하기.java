import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for(int[] cost : costs) {
            pq.add(cost);
        }
        
        int cnt = 0;
        int answer = 0;
        while(!pq.isEmpty()) {
            int[] pos = pq.poll();
            
            if(union(pos[0], pos[1])) {
                answer += pos[2];
                cnt++;
            }
            
            if(cnt == n - 1) break;
        }
        
        return answer;
    }
    
    int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        
        if(aa == bb) return false;
        
        if(aa > bb) {
            int temp = aa;
            aa = bb;
            bb = temp;
        }
        
        parent[bb] = aa;
        
        return true;
    }
}