class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int size = schedules.length;
        
        int cnt = 0;
        for(int i = 0; i < size; i++) {
            boolean flag = true;
            
            int h = schedules[i] / 100;
            int m = schedules[i] % 100;
            
            m += 10;
            if(m >= 60) {
                h += 1;
                m %= 60;
            }
            
            schedules[i] = h * 100 + m;
            
            for(int j = 0; j < 7; j++) {
                int day = startday + j;
                if(day >= 8) day -= 7;
                
                if(day >= 6) continue;
                
                if(schedules[i] < timelogs[i][j]) {
                    flag = false;
                    break;
                }
                
            }
            
            if(flag) cnt++;
        }
        
        return cnt;
    }
}