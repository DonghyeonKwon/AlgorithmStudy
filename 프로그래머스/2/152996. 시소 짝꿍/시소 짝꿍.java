import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Double, Integer> map = new HashMap<>();
        double[] divides = new double[]{1.0, 2.0/3, 1.0/2.0, 3.0/4.0};
        
        Arrays.sort(weights);
        for(int w : weights) {
            for(double d : divides) {
                if(map.containsKey(w * d)) {
                    answer += map.get(w*d);
                }
            }
            map.put(w * 1.0, map.getOrDefault(w * 1.0, 0) + 1);
        }
        
        return answer;
    }
}