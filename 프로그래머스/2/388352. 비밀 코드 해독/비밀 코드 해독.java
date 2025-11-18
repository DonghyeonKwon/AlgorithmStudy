import java.util.*;

class Solution {
    boolean[] checked;
    NumInfo[] info;
    int answer = 0, idx;
    int maxNum;
    
    public int solution(int n, int[][] q, int[] ans) {
        maxNum = n;
        checked = new boolean[n+1];
        info = new NumInfo[ans.length];
        for(int i = 0; i < ans.length; i++) {
            info[i] = new NumInfo(ans[i], q[i]);
        }
        Arrays.sort(info);
        
        if(info[0].ans == 5) {
            return 1;
        }
        
        idx = ans.length - 1;
        while(info[idx].ans == 0) {
            for(int i = 0; i < 5; i++) {
                checked[info[idx].nums[i]] = true;
            }
            idx--;
        }
        
        dfs(1, 0, new int[5]);
        
        return answer;
    }
    
    void dfs(int s, int cnt, int[] arr) {
        if(cnt == 5) {
            for(int i = 0; i <= idx; i++) {
                int pp = 0;
                for(int j = 0; j < 5; j++) {
                    for(int k = 0; k < 5; k++) {
                        if(arr[j] == info[i].nums[k]) pp++;
                    }
                }
                if(pp != info[i].ans) return;
            }
            answer++;
            return;
        }
        
        for(int i = s; i <= maxNum; i++) {
            if(checked[i]) continue;
            arr[cnt] = i;
            checked[i] = true;
            dfs(i + 1, cnt+1, arr);
            checked[i] = false;
            arr[cnt] = 0;
        }
    }
}

class NumInfo implements Comparable<NumInfo> {
    int ans;
    int[] nums;
    
    NumInfo(int ans, int[] nums) {
        this.ans = ans;
        this.nums = nums;
    }
    
    @Override
    public int compareTo(NumInfo o) {
        return o.ans - this.ans;
    }
}