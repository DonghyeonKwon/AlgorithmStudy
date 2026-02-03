import java.util.*;

class Solution {
    int n;
    int[] sale;
    int[][] cost;
    List<Integer>[] list;
    
    public int solution(int[] sales, int[][] links) {
        n = sales.length;
        sale = new int[n+1];
        cost = new int[n+1][2];
        
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            sale[i] = sales[i-1];
            list[i] = new ArrayList<>();
        }
        
        for(int[] arr : links) {
            list[arr[0]].add(arr[1]);
        }
        
        dfs(1);
        
        int answer = Math.min(cost[1][0], cost[1][1]);
        return answer;
    }

    public void dfs(int node) {
        int childCnt = list[node].size();
        
        cost[node][0] = 0;
        cost[node][1] = sale[node];
        
        if(childCnt == 0) return;
        int extraCost = Integer.MAX_VALUE;
        
        for(int next : list[node]) {
            dfs(next);
            
            if(cost[next][0] < cost[next][1]) {
                cost[node][0] += cost[next][0];
                cost[node][1] += cost[next][0];
                
                extraCost = Math.min(extraCost, cost[next][1] - cost[next][0]);
            } else {
                cost[node][0] += cost[next][1];
                cost[node][1] += cost[next][1];
                
                extraCost = 0;
            }
            
        }
        
        cost[node][0] += extraCost;
    }
}