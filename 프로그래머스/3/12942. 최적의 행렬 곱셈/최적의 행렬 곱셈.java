class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                int a = j;
                int b = j + i;
                
                if(a == b) {
                    dp[a][b] = 0;
                } else {
                    dp[a][b] = Integer.MAX_VALUE;
                    for(int k = a; k < b; k++) {
                        dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k+1][b] + (matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]));
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
}