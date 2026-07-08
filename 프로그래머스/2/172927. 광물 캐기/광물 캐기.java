class Solution {
    int answer = Integer.MAX_VALUE;
    int sum = 0;
    
    int[][] dd = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    
    public int solution(int[] picks, String[] minerals) {
        for(int i = 0; i < 3; i++) {
            sum += picks[i];   
        }
        
        go(0, 0, 0, picks, minerals);
        
        return answer;
    }
    
    void go(int idx, int n, int total, int[] picks, String[] minerals) {
        if(n == sum || idx == minerals.length) {
            answer = Math.min(total, answer);
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            if(picks[i] == 0) continue;
            
            int a = 0;
            int j = idx;
            for(; j < idx + 5 && j < minerals.length; j++) {
                int p = -1;
                if(minerals[j].equals("diamond")) p = 0;
                else if(minerals[j].equals("iron")) p = 1;
                else p = 2;
                
                a += dd[i][p];
            }
            
            picks[i]--;
            go(j, n+1, total + a, picks, minerals);
            picks[i]++;
            
        }
    }
}