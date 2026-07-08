import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        PriorityQueue<Subject> pq = new PriorityQueue<>();
        for(int i = 0; i < plans.length; i++) {
            String[] srr = plans[i][1].split(":");
            int start = Integer.parseInt(srr[0]) * 60 + Integer.parseInt(srr[1]);
            int playtime = Integer.parseInt(plans[i][2]);
            Subject sub = new Subject(plans[i][0], start, playtime);
            pq.add(sub);
        }
        
        Stack<Subject> stk = new Stack<>();
        
        while(!pq.isEmpty()) {
            Subject now = pq.poll();
            
            String curName = now.name;
            int curStart = now.start;
            int curPlaytime = now.playtime;
            
            int curTime = curStart;
            
            if(!pq.isEmpty()) {
                Subject next = pq.peek();
                
                if(curStart + curPlaytime < next.start) {
                    answer.add(curName);
                    curTime += curPlaytime;
                    
                    while(!stk.isEmpty()) {
                        Subject sub = stk.pop();
                        
                        if(curTime + sub.playtime <= next.start) {
                            answer.add(sub.name);
                            curTime += sub.playtime;
                            continue;
                        } else {
                            sub.playtime -= (next.start - curTime);
                            stk.push(sub);
                            break;
                        }
                    }
                } else if(curStart + curPlaytime == next.start) {
                    answer.add(curName);
                } else {
                    now.playtime -= (next.start - curTime);
                    stk.push(now);
                }
            } else {
                answer.add(curName);
                while(!stk.isEmpty()) {
                    answer.add(stk.pop().name);
                }
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}

class Subject implements Comparable<Subject> {
    String name;
    int start;
    int playtime;
    
    Subject(String name, int start, int playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }
    
    @Override
    public int compareTo(Subject o) {
        return this.start - o.start;
    }
}