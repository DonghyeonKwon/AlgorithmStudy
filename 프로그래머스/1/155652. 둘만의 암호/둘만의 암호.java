class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        for(char ch : s.toCharArray()) {
            int cnt = 0;
            
            while(cnt < index) {
                if(ch == 'z') {
                    ch = 'a';
                } else {
                    ch++;
                }
                
                if(!skip.contains(String.valueOf(ch))) cnt++;
            }
            
            sb.append(ch);
        }

        return sb.toString();
    }
}