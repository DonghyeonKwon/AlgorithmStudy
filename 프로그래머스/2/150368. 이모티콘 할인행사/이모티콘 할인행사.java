class Solution {
    int n, m;
    int[][] users;
    int[] emo;
    int[] value;
    int[] answer = {0, 0};
    
    int[] dd = {1, 2, 3, 4};
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.n = users.length;
        this.m = emoticons.length;
        this.users = users;
        this.emo = emoticons;
        value = new int[m];
        
        go(0);

        return answer;
    }
    
    private void go(int idx) {
        if(idx == m) {
            int cnt = 0;
            int total = 0;
            
            for(int i = 0; i < n; i++) {
                int sum = 0;
                for(int j = 0; j < m; j++) {
                    if(value[j] >= users[i][0]) {
                        sum += emo[j];
                    }
                }
                
                if(sum >= users[i][1]) cnt++;
                else total += sum;
            }
            
            if(answer[0] < cnt) {
                answer[0] = cnt;
                answer[1] = total;
            } else if(answer[0] == cnt) {
                answer[1] = Math.max(total, answer[1]);
            }
            
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int temp = emo[idx];
            value[idx] = dd[i] * 10;
            emo[idx] = emo[idx] * (10 - dd[i]) / 10;
            go(idx + 1);
            emo[idx] = temp;
        }
    }
}