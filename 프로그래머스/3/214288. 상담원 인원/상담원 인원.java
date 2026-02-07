import java.util.*;
import java.util.*;

class Solution {
    List<Info>[] list;
    int[][] map;
    int k, n, min = Integer.MAX_VALUE;
    
    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;
        
        list = new ArrayList[k+1];
        for(int i = 1; i <= k; i++) {
            list[i] = new ArrayList<>();
        }
        
        
        for(int[] req : reqs) {
            list[req[2]].add(new Info(req[0], req[1]));
        }
        
        map = new int[k+1][n - k + 2]; //int[각 유형 별][상담원 수] = 참여자가 기다려야 할 시간
        
        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= n - k + 1; j++) {
                getWaitingTime(i, j);
            }
        }
        
        dfs(1, 0, 0);
        
        return min;
    }
    
    private void dfs(int idx, int cnt, int time) {
        if(idx < k && cnt >= n) return;
        
        if(idx > k) {
            if(cnt != n) return;
            min = Math.min(min, time);
            return;
        }
        
        for(int i = 1; i <= n - k + 1; i++) {
            dfs(idx + 1, cnt + i, time + map[idx][i]);
        }
    }
    
    private void getWaitingTime(int idx, int cnt) {
        if(list[idx].size() <= cnt) {
            map[idx][cnt] = 0;
            return;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int waitingTime = 0;
        
        for(int i = 0; i < list[idx].size(); i++) {
            Info info = list[idx].get(i);
            if(pq.size() >= cnt) {
                int peek = pq.poll();
                if(peek <= info.start) {
                    pq.add(info.end + info.start);
                } else {
                    waitingTime += peek - info.start;
                    pq.add(peek + info.end);
                }
            } else {
                pq.add(info.end + info.start);
            }
        }
        
        map[idx][cnt] = waitingTime;
    }
    
    class Info {
        int start;
        int end;
        
        Info(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}