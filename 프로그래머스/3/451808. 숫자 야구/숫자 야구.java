import java.util.function.Function;
import java.util.*;

class Solution {
    
    public int solution(int n, Function<Integer, String> submit) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1000; i <= 9999; i++) {
            if(valid(i)) list.add(i);
        }
        
        int tries = 0;
        while(list.size() > 1 && tries < n) {
            int num = list.get(0);
            String result = submit.apply(num);
            tries++;
            
            String[] sarr = result.split(" ");
            int s = Integer.parseInt(sarr[0].replace("S", ""));
            int b = Integer.parseInt(sarr[1].replace("B", ""));
            
            List<Integer> next = new ArrayList<>();
            for(int k : list) {
                int[] ret = calc(num, k);
                if(ret[0] == s && ret[1] == b) {
                    next.add(k);
                }
            }
            list = next;
        }
            
        return list.get(0);
    }
    
    int[] calc(int a, int b) {
        char[] A = String.valueOf(a).toCharArray();
        char[] B = String.valueOf(b).toCharArray();
        
        int strike = 0, ball = 0;
        
        for(int i = 0; i < 4; i++) {
            if(A[i] == B[i]) strike++;
            else if(String.valueOf(b).indexOf(A[i]) != -1) ball++;
        }
        
        return new int[]{strike, ball};
    }
    
    boolean valid(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 4; i++) {
            if(arr[i] == '0') return false;
            set.add(arr[i]);
        }
        
        return set.size() == 4;
        
    }
}