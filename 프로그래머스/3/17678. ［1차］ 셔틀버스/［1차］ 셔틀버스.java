import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < timetable.length; i++) {
            String[] srr = timetable[i].split(":");
            pq.add(Integer.parseInt(srr[0]) * 60 + Integer.parseInt(srr[1]));
        }
        
        int time = 540;
        int ret = 0, person = 0;
        for(int i = 0; i < n; i++) {
            person = 0;
            while(!pq.isEmpty()) {
                int curTime = pq.peek();
                
                if(curTime <= time && person < m) {
                    person++;
                    pq.poll();
                } else break;
                
                ret = curTime - 1;
            }
            time += t;
        }
        
        if(person < m) {
            ret = time - t;
        }
        
        String hour = String.valueOf(ret / 60);
        String min = String.valueOf(ret % 60);
        
        if(hour.length() == 1) hour = "0" + hour;
        if(min.length() == 1) min = "0" + min;
        
        return hour + ":" + min;
    }
}