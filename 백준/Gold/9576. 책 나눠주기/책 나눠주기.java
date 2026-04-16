import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[n+1];

            int[][] arr = new int[m][2];

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            Arrays.sort(arr, (o1, o2) -> {
               if(o1[1] == o2[1]) {
                   return o1[0] - o2[0];
               }
                return o1[1] - o2[1];
            });

            for(int i = 0; i < m; i++) {
                for(int j = arr[i][0]; j <= arr[i][1]; j++) {
                    if(visited[j]) continue;
                    visited[j] = true;
                    cnt++;
                    break;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}
