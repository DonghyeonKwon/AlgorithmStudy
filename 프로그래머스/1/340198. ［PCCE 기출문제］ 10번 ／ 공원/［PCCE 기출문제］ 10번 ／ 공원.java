import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int n = park.length;
        int m = park[0].length;
        
        Arrays.sort(mats);
        
        for(int k = mats.length - 1; k >= 0; k--) {
            int mat = mats[k];
            for(int i = 0; i <= n - mat; i++) {
                for(int j = 0; j <= m - mat; j++) {
                    if(!park[i][j].equals("-1")) continue;
                    
                    boolean flag = true;
                    
                    loop : for(int ii = i; ii < i + mat; ii++) {
                        for(int jj = j; jj < j + mat; jj++) {
                            if(!park[ii][jj].equals("-1")) {
                                flag = false;
                                break loop;
                            }
                        }
                    }
                    
                    if(flag) return mat;
                }
            }
        }
        
        return -1;
    }
}