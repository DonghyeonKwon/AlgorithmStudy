import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(x, y);
        }

        int[][] dp = new int[k+1][n];
        for(int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;

        int min, temp;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                if(i - j > 0) {
                    min = Integer.MAX_VALUE;

                    for(int p = 0; p <= j; p++) {
                        temp = dp[j-p][i-p-1];
                        if(temp == -1) continue;
                        int dis = dist(nodes[i], nodes[i-p-1]);
                        min = Math.min(min, temp + dis);
                    }
                    dp[j][i] = min;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i <= k; i++) {
            result = Math.min(result, dp[i][n-1]);
        }

        System.out.print(result);

    }

    static int dist(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
