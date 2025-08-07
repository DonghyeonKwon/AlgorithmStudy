import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] inDegree = new int[n+1];
        List<List<Integer>>  list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            inDegree[b]++;
        }
        
        List<Integer> res = new ArrayList<>();
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        if(q.size() == 0) {
            System.out.print("No");
            return;
        }
        
        int cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            res.add(cur);
            for(int idx : list.get(cur)) {
                inDegree[idx]--;
                if(inDegree[idx] == 0) {
                    q.add(idx);
                }
            }
        }
        
        if(res.size() != n) {
            System.out.print("No");
            return;
        }
        
        for(int a : res) {
            System.out.print(a + " ");
        }
    }
}
