class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] arr = new int[26];
        for(int i = 0; i < 26; i++) {
            arr[i] = -1;
        }
        
        for(int i = 0; i < s.length(); i++) {
           if(arr[s.charAt(i) - 'a'] == -1) {
               answer[i] = -1;
               arr[s.charAt(i) - 'a'] = i;
           } else {
               answer[i] = i - arr[s.charAt(i) - 'a'];
               arr[s.charAt(i) - 'a'] = i;
           }
        }
        
        return answer;
    }
}