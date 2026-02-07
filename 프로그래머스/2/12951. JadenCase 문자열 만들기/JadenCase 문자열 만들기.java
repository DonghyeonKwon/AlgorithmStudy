import java.util.*;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        
        int n = arr.length;
        
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i = 0; i < n; i++) {
            if(arr[i] == ' ') {
                sb.append(' ');
                flag = true;
                continue;
            }
            
            if(flag) {
                if('a' <= arr[i] && arr[i] <= 'z') {
                    char c = 'A';
                    c += (arr[i] - 'a');
                    sb.append(c);
                } else {
                    sb.append(arr[i]);
                }
                flag = false;
            } else {
                if('A' <= arr[i] && arr[i] <= 'Z') {
                    char c = 'a';
                    c += (arr[i] - 'A');
                    sb.append(c);
                } else {
                    sb.append(arr[i]);
                }
            }
        }

        return sb.toString();
    }
}