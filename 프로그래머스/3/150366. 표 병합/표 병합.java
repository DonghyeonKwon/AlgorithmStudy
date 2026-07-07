import java.util.*;

class Solution {
    int len = 2500;
    int[] grp = new int[len];
    String[] arr = new String[len];
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        for(int i = 0; i < len; i++) {
            grp[i] = i;
        }
        
        for(int i = 0; i < commands.length; i++) {
            String[] cmd = commands[i].split(" ");
            
            if(cmd[0].equals("UPDATE")) {
                if(cmd.length == 3) {
                    for(int j = 0; j < len; j++) {
                        if(arr[find(j)] != null && arr[find(j)].equals(cmd[1])) {
                            arr[find(j)] = cmd[2];
                        }
                    }
                } else {
                    int y = Integer.parseInt(cmd[1]) - 1;
                    int x = Integer.parseInt(cmd[2]) - 1;
                    arr[find(y * 50 + x)] = cmd[3];
                }
            } else if(cmd[0].equals("MERGE")) {
                int y1 = Integer.parseInt(cmd[1]) - 1;
                int x1 = Integer.parseInt(cmd[2]) - 1;
                
                int y2 = Integer.parseInt(cmd[3]) - 1;
                int x2 = Integer.parseInt(cmd[4]) - 1;
                
                int idx1 = y1 * 50 + x1;
                int idx2 = y2 * 50 + x2;
                
                if(arr[find(idx1)] == null && arr[find(idx2)] != null) {
                    int temp = idx1;
                    idx1 = idx2;
                    idx2 = temp;
                }
                
                union(idx1, idx2);
            } else if(cmd[0].equals("UNMERGE")) {
                int y = Integer.parseInt(cmd[1]) - 1;
                int x = Integer.parseInt(cmd[2]) - 1;
                
                int idx = find(y * 50 + x);
                String str = arr[idx];
                
                for(int j = 0; j < len; j++) {
                    find(j);
                }
                
                for(int j = 0; j < len; j++) {
                    if(find(j) == idx) {
                        grp[j] = j;
                        
                        if(j == y * 50 + x) {
                            arr[j] = str;
                        } else {
                            arr[j] = null;
                        }
                    }
                }
            } else if(cmd[0].equals("PRINT")) {
                int y = Integer.parseInt(cmd[1]) - 1;
                int x = Integer.parseInt(cmd[2]) - 1;
                int idx = y * 50 + x;
                
                String str = arr[find(idx)];
                answer.add(str == null ? "EMPTY" : str);
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
    
    int find(int x) {
        if(x == grp[x]) return x;
        return grp[x] = find(grp[x]);
    }
    
    void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b) return;
        
        arr[b] = null;
        grp[b] = a;
    }
}