class Solution {
    public long[] solution(int[] arr, long l, long r) {
        int n = arr.length;
        long[] end = new long[n];
        long[] psum = new long[n];
        
        long lenSum = 0;
        long valueSum = 0;
        
        for(int i = 0; i < n; i++) {
            long x = arr[i];
            
            lenSum += x;
            valueSum += x * x;
            
            end[i] = lenSum;
            psum[i] = valueSum;
        }
        
        long len = r - l + 1;
        long sum = 0;

        long K = getPrefix(r, arr, end, psum) - getPrefix(l-1, arr, end, psum);
        long C = containPrefix(arr, end, psum, len, K);
        
        long[] answer = {K, C};
        return answer;
    }
    
    long containPrefix(int[] arr, long[] end, long[] psum, long len, long target) {
        int n = arr.length;
        
        long totalLen = end[n-1];
        long maxStart = totalLen - len + 1;
        
        long currentSum = getPrefix(len, arr, end, psum);
        long count = 0;
        if(currentSum == target) {
            count++;
        }
        
        long s = 1;
        int out = 0;
        int in = 0;
        
        while(s < maxStart) {
            while(s > end[out]) {
                out++;
            }
            
            while(s + len > end[in]) {
                in++;
            }
            
            long outVal = arr[out];
            long inVal = arr[in];
            long diff = inVal - outVal;
            
            long lastMove = Math.min(end[out], end[in] - len);
            lastMove = Math.min(lastMove, maxStart - 1);
            
            long moveCount = lastMove - s + 1;
            
            if(diff == 0) {
                if (currentSum == target) {
                    count += moveCount;
                }
            } else {
                long gap = target - currentSum;
                
                if(gap % diff == 0) {
                    long step = gap / diff;
                    
                    if(1 <= step && step <= moveCount) count++;
                }
            }
            
            currentSum += diff * moveCount;
            s += moveCount;
        }
        
        return count;
    }
    
    long getPrefix(long pos, int[] arr, long[] end, long[] psum) {
        if(pos <= 0) return 0;
        
        int idx = lowerBound(end, pos);
        
        long beforeLen = idx == 0 ? 0 : end[idx - 1];
        long beforeSum = idx == 0 ? 0 : psum[idx - 1];
        
        long remain = pos - beforeLen;
        
        return beforeSum + remain * arr[idx];
    }
    
    int lowerBound(long[] arr, long pos) {
        int l = 0;
        int r = arr.length;
        
        while(l < r) {
            int mid = (l + r) / 2;
            if(arr[mid] >= pos) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}