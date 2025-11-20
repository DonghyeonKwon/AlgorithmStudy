import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for(String friend : friends) {
            map.put(friend, idx++);
        }
        
        int[][] arr = new int[idx][idx];
        int[] presentX = new int[idx];
        
        for(String gift : gifts) {
            String[] info = gift.split(" ");
            
            arr[map.get(info[0])][map.get(info[1])]++;
            presentX[map.get(info[0])]++;
            presentX[map.get(info[1])]--;
        }
        
        int[] cnt = new int[idx];
        for(int i = 0; i < idx; i++) {
            for(int j = i+1; j < idx; j++) {
                if(arr[i][j] > arr[j][i]) {
                    cnt[i]++;
                } else if(arr[i][j] < arr[j][i]) {
                    cnt[j]++;
                } else {
                    if(presentX[i] < presentX[j]) {
                        cnt[j]++;
                    } else if(presentX[j] < presentX[i]) {
                        cnt[i]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < idx; i++) {
            answer = Math.max(answer, cnt[i]);
        }
        return answer;
    }
    
}