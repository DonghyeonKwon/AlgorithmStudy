import java.util.*;

class Solution {
    public int solution(String[] lines) {
        List<Job> list = new ArrayList<>();
        
        for(int i = 0; i < lines.length; i++) {
            String[] time = lines[i].split(" ");
            long end = getMillisecond(time[1]);
            long start = end - (long) (Double.parseDouble(time[2].replace("s", "")) * 1000) + 1;
            list.add(new Job(start, end));
        }
        
        int ans = 1;
        for(int i = 0; i < list.size(); i++) {
            int cnt = 0;
            long end = list.get(i).end;
            for(Job job : list) {
                if(job.start < end + 1000 && job.end >= end) cnt++;
            }
            
            ans = Math.max(ans, cnt);
        }
        
        return ans;
    }
    
    long getMillisecond(String str) {
        long val = 0;
        String[] arr = str.split(":");
        
        val += Long.parseLong(arr[0]) * 60 * 60;
        val += Long.parseLong(arr[1]) * 60;
        val *= 1000;
        
        val += Double.parseDouble(arr[2]) * 1000;
        
        return val;
    }
    
    static class Job {
        long start, end;
        
        Job(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}