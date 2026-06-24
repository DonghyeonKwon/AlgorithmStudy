class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < n; i++) {
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.max(triangle[i][j] + dp[i-1][j-1], triangle[i][j] + dp[i-1][j]);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
}