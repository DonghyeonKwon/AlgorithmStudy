import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a);
        Set<Integer> set = new HashSet<>();
        
        for(String cmd : operations) {
            String[] arr = cmd.split(" ");
            char c = arr[0].charAt(0);
            int num = Integer.parseInt(arr[1]);
            if(c == 'I') {
                pq.add(num);
                pq1.add(num);
            } else {
                if(!pq.isEmpty()) {
                    if(num == 1) {
                        int max = pq1.poll();
                        pq.remove(max);
                    } else if(num == -1){
                        int min = pq.poll();
                        pq1.remove(min);
                    }
                }
            }
        }
        
        int[] answer = {0, 0};
        if(pq.size() >= 1) {
            answer[0] = pq1.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}