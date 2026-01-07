import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] matrix;
    static int[][] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n+1][n+1];
        ans = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) matrix[i][j] = 0;
                else matrix[i][j] = 1_000_000_000;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            matrix[u][v] = c;
            matrix[v][u] = c;
            ans[u][v] = v;
            ans[v][u] = u;
        }

        floydWarshall();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(ans[i][j] == 0) {
                    sb.append("- ");
                } else {
                    int t = j;
                    while (ans[i][t] != t) {
                        t = ans[i][t];
                    }

                    sb.append(ans[i][t] + " ");
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void floydWarshall() {
        for(int t = n; t >= 1; t--) {
            for(int s = 1; s <= n; s++) {
                for(int e = 1; e <= n; e++) {
                    if(matrix[s][e] > matrix[s][t] + matrix[t][e]) {
                        matrix[s][e] = matrix[s][t] + matrix[t][e];
                        ans[s][e] = t;
                    }
                }
            }
        }
    }
}
