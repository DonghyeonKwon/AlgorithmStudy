class Solution {
    int n, max = -1;
    int[] info;
    int[][] edges;
    
    public int solution(int[] info, int[][] edges) {
        this.n = info.length;
        this.info = info;
        this.edges = edges;
        
        dfs(0, 0, 0, 0);
        return max;
    }
    
    void dfs(int node, int visited, int wolf, int sheep) {
        visited |= (1 << node);
    
        if(info[node] == 0) {
            sheep += 1;
            if(sheep > max) {
                max = sheep;
            }
        } else {
            wolf += 1;
        }
        
        if(sheep <= wolf) return;
        
        for(int[] edge : edges) {
            int now = edge[0];
            int next = edge[1];
            
            if((visited & (1 << now)) > 0 && (visited & (1 << next)) == 0) {
                dfs(next, visited, wolf, sheep);
            }
        }
    }
}
