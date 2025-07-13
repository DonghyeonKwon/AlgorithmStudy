import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
           if(o1[1] == o2[1]) {
               return o1[0] - o2[0];
           }
           return o1[1] - o2[1];
        });

        int end = arr[0][1];
        int cnt = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i][0] < end) continue;
            end = arr[i][1];
            cnt++;
        }

        System.out.print(cnt);
    }
}
