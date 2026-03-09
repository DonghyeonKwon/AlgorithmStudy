import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) + 1;

        Node[] node = new Node[n];
        int psum = 0;
        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cpu = Integer.parseInt(st.nextToken());
            int memory = Integer.parseInt(st.nextToken());
            int priority = Integer.parseInt(st.nextToken());
            node[i] = new Node(cpu, memory, priority);
            psum += priority;
        }

        int[][] dp = new int[c+1][psum+1];
        dp[0][0] = 1;

        for(Node now : node) {
            for(int i = c; i >= 0; i--) {
                for(int j = psum; j >= 0; j--) {
                    int nextC = Math.min(c, i + now.cpu);
                    int nextP = j + now.priority;
                    if(dp[i][j] != 0) {
                        dp[nextC][nextP] = Math.max(dp[nextC][nextP], dp[i][j] + now.memory);
                    }
                }
            }
        }

        for(int i = 1; i <= psum; i++) {
            if(dp[c][i] >= m) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(-1);
    }

    static class Node {
        int cpu, memory, priority;

        Node(int cpu, int memory, int priority) {
            this.cpu = cpu;
            this.memory = memory;
            this.priority = priority;
        }
    }
}
