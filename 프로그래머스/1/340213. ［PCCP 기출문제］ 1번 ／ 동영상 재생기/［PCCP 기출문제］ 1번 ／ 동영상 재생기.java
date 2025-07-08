import java.util.StringTokenizer;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int start_second = parseStringtoInt(op_start);
        int end_second = parseStringtoInt(op_end);
        int pos_second = parseStringtoInt(pos);
        int video_second = parseStringtoInt(video_len);
        
        for(String cmd : commands) {
            if(start_second <= pos_second && pos_second <= end_second) {
                pos_second = end_second;   
            }
            
            if(cmd.equals("next")) {
                pos_second += 10;
            } else { //prev
                pos_second -= 10;
            }
            
            if(pos_second < 0) pos_second = 0;
            if(pos_second >= video_second) pos_second = video_second;
        }
        
        if(start_second <= pos_second && pos_second <= end_second) {
            pos_second = end_second;   
        }
        
        StringBuilder sb = new StringBuilder();
        int mm, ss;
        
        mm = pos_second / 60;
        ss = pos_second % 60;
        
        sb.append(mm < 10 ? "0" + mm : mm).append(':').append(ss < 10 ? "0" + ss : ss);
        
        return sb.toString();
    }
    
    int parseStringtoInt(String str){
        StringTokenizer st = new StringTokenizer(str, ":");
        
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
}