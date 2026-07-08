class Solution {
    long answer = 0;
    public long solution(int[] sequence) {
        int n = sequence.length;
        int[] arr = new int[n];
        int[] brr = new int[n];
        
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                arr[i] = sequence[i];
                brr[i] = sequence[i] * -1;
            } else {
                arr[i] = sequence[i] * -1;
                brr[i] = sequence[i];
            }
        }
        
        check(arr, n);
        check(brr, n);
        
        return answer;
    }
    
    void check(int[] arr, int len) {
        long total = 0;
        for(int l = 0, r = 0; l < len; l++) {
            while(total >= 0 && r < len) {
                total += arr[r];
                answer = Math.max(total, answer);
                r++;
            }
            total -= arr[l];
        }
    }
}