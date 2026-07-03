class Solution {
    int n = 0, answer = Integer.MAX_VALUE;
    int[][] cost;
    int[][] hint;

    public int solution(int[][] cost, int[][] hint) {
        n = cost.length;
        this.cost = cost;
        this.hint = hint;
        
        go(0, 0, new int[n]);
        
        return answer;
    }
    
    void go(int idx, int sum, int[] arr) {
        if(idx == n) {
            answer = Math.min(answer, sum);
            return;
        }
        
        go(idx + 1, sum + cost[idx][arr[idx] >= n ? n-1 : arr[idx]], arr);
        
        if(idx == n-1) return;

        for(int i = 1; i < hint[idx].length; i++){
            arr[hint[idx][i] - 1]++;
        }
        
        go(idx + 1, sum + cost[idx][arr[idx] >= n ? n-1 : arr[idx]] + hint[idx][0], arr);
        
        for(int i = 1; i < hint[idx].length; i++){
            arr[hint[idx][i] - 1]--;
        }
    }
}