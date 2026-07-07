class Solution {
    public int solution(int n, long l, long r) {
        return (int)(count(n, r) - count(n, l - 1));
    }
    
    public long count(int n, long k) {
        if(n == 0) {
            return 1;
        }
        
        long p = n - 1;
        long divisor = (long) Math.pow(5, p);
        long oneCnt = (long) Math.pow(4, p);
        
        long zone = (int)(k / divisor);
        if((k % divisor) == 0) zone--;
        
        if(zone == 2) {
            return oneCnt * zone;
        } else if(zone < 2) {
            return oneCnt * zone + count(n - 1, k - divisor * zone);
        } else {
            return oneCnt * (zone - 1) + count(n - 1, k - divisor * zone);
        }
    }
}