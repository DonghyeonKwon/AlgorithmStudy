class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int row = (num-1) / w;
        int idx = w-1;
        int col = 0;
        
        if(row % 2 == 0){
            col = (num-1) % w;
        } else {
            col = idx - (num-1) % w;
        }
        
        for(; row < (n + idx) / w; row++){
            
            int upBox = 0;
            
            if(row % 2 == 0){
                upBox = col + (row * w);
            } else {
                upBox = (idx - col) + (row * w);
            }
            
            if(upBox < n) answer++;
        }
        
        return answer;
    }
}