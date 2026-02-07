import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extInt = getExtInteger(ext);
        List<int[]> list = new ArrayList<>();
        
        int len = data.length;
        for(int i = 0; i < len; i++) {
            if(data[i][extInt] < val_ext) {
                list.add(data[i]);
            }
        }
        
        int sortIdx = getExtInteger(sort_by);
        Collections.sort(list, (o, p) -> o[sortIdx] - p[sortIdx]);
        
        len = list.size();
        int[][] answer = new int[len][];
        for(int i = 0; i < len; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private int getExtInteger(String s) {
        int extInt = 0;
        if(s.equals("code")) {
            extInt = 0;
        } else if(s.equals("date")) {
            extInt = 1;
        } else if(s.equals("maximum")) {
            extInt = 2;
        } else if(s.equals("remain")) {
            extInt = 3;
        }
        
        return extInt;
    }
}