import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            list = new int[n+1][n+1];

            for(int i = 1; i <= n; i++) {
                Arrays.fill(list[i], Integer.MAX_VALUE / 2);
                list[i][i] = 0;
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list[a][b] = c;
                list[b][a] = c;
            }

            k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[k];
            for(int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int p = 1; p <= n; p++) {
                for(int i = 1; i <= n; i++) {
                    for(int j = 1; j <= n; j++) {
                        list[i][j] = Math.min(list[i][j], list[i][p] + list[p][j]);
                    }
                }
            }
            int sum = Integer.MAX_VALUE;
            int res = 0;
            for(int i = 1; i <= n; i++) {
                int tmp = 0;
                for(int j = 0; j < k; j++) {
                    tmp += list[i][arr[j]];
                }

                if(sum > tmp) {
                    sum = tmp;
                    res = i;
                }
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

}
