class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        
        int[] prevMin = new int[len];
        int[] nextMin = new int[len];
        
        int min = a[0];
        for(int i = 0; i < len; i++) {
            if(a[i] < min) min = a[i];
            prevMin[i] = min;
        }
        
        min = a[len - 1];
        for(int i = len-1; i >= 0; i--) {
            if(a[i] < min) min = a[i];
            nextMin[i] = min;
        }
        
        for(int i = 0; i < len; i++) {
            if(prevMin[i] == a[i] || nextMin[i] == a[i]) answer++;
        }
        
        return answer;
    }
}