import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        int[] visited = new int[y + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[x] = 0;
        q.add(new int[]{x, 0});
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            
            if(pos[0] == y) return pos[1];
            
            if(pos[0] + n <= y && pos[1] + 1 < visited[pos[0] + n]) {
                visited[pos[0] + n] = pos[1] + 1;
                q.add(new int[]{pos[0] + n, pos[1] + 1});
            }
            
            if(pos[0] * 2 <= y && pos[1] + 1 < visited[pos[0] * 2]) {
                visited[pos[0] * 2] = pos[1] + 1;
                q.add(new int[]{pos[0] * 2, pos[1] + 1});
            }
            
            if(pos[0] * 3 <= y && pos[1] + 1 < visited[pos[0] * 3]) {
                visited[pos[0] * 3] = pos[1] + 1;
                q.add(new int[]{pos[0] * 3, pos[1] + 1});
            }
        }
        
        return -1;
    }
}