import java.io.*;
import java.util.*;

public class Main {
    
    static char[] c1, c2, out;
    static boolean[][] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            bw.write("Data set ");
            bw.write(Integer.toString(i));
            bw.write(": ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            c1 = st.nextToken().toCharArray();
            c2 = st.nextToken().toCharArray();
            out = st.nextToken().toCharArray();
            bw.write(bfs() ? "yes\n" : "no\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        check = new boolean[201][201];
        q.add(new int[] {0, 0, 0});
        check[0][0] = true;
        
        while(!q.isEmpty()) {
            int idx1 = q.peek()[0];
            int idx2 = q.peek()[1];
            int outIdx = q.peek()[2];
            q.poll();
            
            if(outIdx == out.length) return true;
            
            if(idx1 < c1.length && !check[idx1+1][idx2] && c1[idx1] == out[outIdx]) {
                q.add(new int[] {idx1+1, idx2, outIdx+1});
                check[idx1+1][idx2] = true;
            }

            if(idx2 < c2.length && !check[idx1][idx2+1] && c2[idx2] == out[outIdx]) {
                q.add(new int[] {idx1, idx2+1, outIdx+1});
                check[idx1][idx2+1] = true;
            }
        }

        return false;
    }
}
