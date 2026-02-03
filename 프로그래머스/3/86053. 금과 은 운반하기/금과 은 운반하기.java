class Solution {
    int n;
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        n = g.length;
        long start = 0;
        long end = (long)(10e9 * 2 * 10e5 * 2);
        long answer = (long)(10e9 * 2 * 10e5 * 2);
        
        while(start <= end) {
            long mid = (start + end) / 2;
            int gold = 0;
            int silver = 0;
            int add = 0;
            
            for(int i = 0; i < n; i++) {
                int nowGold = g[i];
                int nowSilver = s[i];
                int nowWeight = w[i];
                long nowTime = t[i];
                
                long moveCnt = mid / (nowTime * 2);
                if(mid % (nowTime*2) >= nowTime) {
                    moveCnt++;
                }
                
                gold += Math.min(nowGold, nowWeight * moveCnt);
                silver += Math.min(nowSilver, nowWeight * moveCnt);
                add += Math.min(nowGold + nowSilver, nowWeight * moveCnt);
            }
            
            if(a <= gold && b <= silver && a + b <= add) {
                end = mid - 1;
                answer = Math.min(answer, mid);
                continue;
            }
            
            start = mid + 1;
        }
        
        return answer;
    }
}