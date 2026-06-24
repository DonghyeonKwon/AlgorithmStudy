class Solution {
    public int solution(int[][] signals) {
        int len = signals.length;
        
        TrafficLight[] traffics = new TrafficLight[len];
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            traffics[i] = new TrafficLight(signals[i][0], signals[i][1], signals[i][2]);
            arr[i] = traffics[i].totalTime;
        }
        
        int maxTime = getLcm(arr);
        for(int i = 1; i <= maxTime; i++) {
            boolean isEquals = true;
            
            for(int j = 0; isEquals && j < len; j++) {
                isEquals &= traffics[j].isYellow(i);
            }
            
            if(isEquals) return i;
        }
        
        return -1;
    }
    
    int getLcm(int[] arr) {
        if(arr.length == 1) return arr[0];
        
        int gcd = getGcd(arr[0], arr[1]);
        int lcm = arr[0] * arr[1] / gcd;
        
        for(int i = 2; i < arr.length; i++) {
            gcd = getGcd(arr[i], lcm);
            lcm = arr[i] * lcm / gcd;
        }
        
        return lcm;
   }
    
    int getGcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    class TrafficLight {
        int greenLimit;
        int yellowLimit;
        int totalTime;
        
        TrafficLight(int green, int yellow, int red) {
            this.greenLimit = green;
            this.yellowLimit = green + yellow;
            this.totalTime = green + yellow + red;
        }
        
        boolean isYellow(int time) {
            time %= totalTime;
            return greenLimit < time && time <= yellowLimit;
        }
    }
}