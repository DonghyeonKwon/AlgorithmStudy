import java.util.*;

class Solution {
    private int hol = 0, revhol = 0;
    private Map<Integer, List<Integer>> map;
    private Set<Integer> visited;
    
    public int[] solution(int[] nodes, int[][] edges) {
        map = new HashMap<>();
        visited = new HashSet<>();
        
        for(int node : nodes) {
            map.put(node, new ArrayList<>());
        }
        
        for(int[] arr : edges) {
            int a = arr[0];
            int b = arr[1];
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        int[] answer = {0, 0};
        
        for(int node : nodes) {
            if(visited.contains(node)) continue;
            
            hol = 0;
            revhol = 0;
            bfs(node);
            
            if(hol == 1) {
                answer[1]++;
            }
            if(revhol == 1) {
                answer[0]++;
            }
        }
        
        
        return answer;
    }
    
    private void bfs(int node) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited.add(node);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            int cnt = map.get(now).size() - 1;
            
            if(now % 2 == 0) {
                if(cnt % 2 == 0) {
                    hol++;
                } else {
                    revhol++;
                }
            } else {
                if(cnt % 2 == 1) {
                    hol++;
                } else {
                    revhol++;
                }
            }
            
            for(int next : map.get(now)) {
                if(visited.contains(next)) continue;
                q.add(next);
                visited.add(next);
            }
        }
    }
}