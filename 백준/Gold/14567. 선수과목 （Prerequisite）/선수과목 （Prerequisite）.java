import java.io.*;
import java.util.*;

public class Main {
    
    static int[] node = new int[1001];
    static boolean[][] arr = new boolean[1001][1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            node[i] = 1;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = true;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(arr[i][j]) {
                    node[j] = Math.max(node[j], node[i] + 1);
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            System.out.print(node[i] + " ");
        }
    }
}
