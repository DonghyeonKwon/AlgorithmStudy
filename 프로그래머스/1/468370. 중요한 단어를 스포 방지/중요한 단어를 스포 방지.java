import java.util.*;

class Solution {
    
    public int solution(String message, int[][] spoiler_ranges) {
        int curIdx = 0;
        
        List<String> spoilerWord = new ArrayList<>();
        Set<String> noSpoilerWord = new HashSet<>();
        
        for(String str : message.split(" ")) {
            int start = message.indexOf(str, curIdx);
            int end = start + str.length() - 1;
            curIdx = end + 1;
            
            boolean spoiler = false;
            
            for(int[] range : spoiler_ranges) {
                if(range[0] <= end && range[1] >= start) {
                    spoilerWord.add(str);
                    spoiler = true;
                    break;
                }
            }
            
            if(!spoiler) {
                noSpoilerWord.add(str);
            }
        }
        
        Set<String> answerSet = new HashSet<>();
        for(String str : spoilerWord) {
            if(!noSpoilerWord.contains(str)) {
                answerSet.add(str);
            }
        }        
        return answerSet.size();
    }
}