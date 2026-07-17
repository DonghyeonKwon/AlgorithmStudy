class Solution {
    int answer = 0;
    
    public int solution(int n) {
        int mulNum = getMulNum(n);
        int plusNum = mulNum * 2;
        
        int answer = go(n-2, mulNum, plusNum - 2);
        return answer;
    }
    
    int getMulNum(int n) {
        return (int) (Math.log(n) / Math.log(3));
    }
    
    int go(int n, int mulNum, int plusNum) {
        if(mulNum * 2 < plusNum) return 0;
        if(n == 3 && mulNum == 1 && plusNum == 0) return 1;
        if(n == 4 && mulNum == 1 && plusNum == 1) return 1;
        if(n == 5 && mulNum == 1 && plusNum == 2) return 1;
        
        int count = 0;
        for(int i = 0; i <= plusNum; i++) {
            if(n - i > 0 && (n - i) % 3 == 0) {
                count += go((n-i) / 3, mulNum - 1, plusNum - i);
            }
        }
        
        return count;
    }
}