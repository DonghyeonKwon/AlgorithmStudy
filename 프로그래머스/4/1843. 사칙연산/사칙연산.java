class Solution {
    int n;
    int[] num;
    char[] op;
    
    public int solution(String arr[]) {
        n = arr.length/2;
        num = new int[n + 1];
        op = new char[n];
        
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) {
                num[i/2] = Integer.parseInt(arr[i]);
            } else {
                op[i/2] = arr[i].charAt(0);
            }
        }
        
        int[][] max = new int[n+1][n+1];
        int[][] min = new int[n+1][n+1];
        
        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < n+1; j++) {
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
            
            max[i][i] = num[i];
            min[i][i] = num[i];
        }
        
        for(int d = 0; d < n + 1; d++) {
            for(int i = 0; i < n + 1 - d; i++) {
                int j = i + d;
                
                for(int k = i; k < j; k++) {
                    if(op[k] == '+') {
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k+1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k+1][j]);
                    } else {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k+1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k+1][j]);
                    }
                }
            }
        }
        
        return max[0][n];
    }
}