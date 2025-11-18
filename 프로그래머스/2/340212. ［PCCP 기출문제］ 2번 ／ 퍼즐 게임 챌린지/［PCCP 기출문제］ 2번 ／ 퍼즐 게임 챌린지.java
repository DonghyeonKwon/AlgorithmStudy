class Solution {
    int n;
    int[] arr;
    int[] timeArr;
    long limitTime;
    
    public int solution(int[] diffs, int[] times, long limit) {
        n = diffs.length;
        arr = diffs;
        timeArr = times;
        limitTime = limit;
        
        int l = 1;
        int r = 100000;
        int ans = 0;
        while(l <= r) {
            int mid = (l + r) / 2;
            
            if(calc(mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
            
        }

        return ans;
    }
    
    boolean calc(int level) {
        long totalTime = 0L;
        long timePrev = 0L;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] <= level) {
                totalTime += timeArr[i];
            } else {
                int gap = arr[i] - level;
                long t = (timePrev + timeArr[i]) * gap + timeArr[i];
                totalTime += t;
            }
            timePrev = timeArr[i];
        }
        return totalTime <= limitTime;
    }
}