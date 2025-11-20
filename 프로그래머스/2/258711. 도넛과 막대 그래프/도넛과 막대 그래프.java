import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            out.put(a, out.getOrDefault(a, 0) + 1);
            in.put(b, in.getOrDefault(b, 0) + 1);
        }
        
        for(int node : out.keySet()) {
            if(out.get(node) > 1) {
                if(!in.containsKey(node)) {
                    answer[0] = node;
                } else {
                    answer[3] += 1;
                }
            }
        }
        
        for(int node : in.keySet()) {
            if(!out.containsKey(node)) {
                answer[2] += 1;
            }
        }
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}