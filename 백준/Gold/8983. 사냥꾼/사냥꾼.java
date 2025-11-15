import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static long l;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Long.parseLong(st.nextToken());

        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] animal = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            animal[i][0] = Integer.parseInt(st.nextToken());
            animal[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int s = 0;
            int e = m - 1;
            while(s <= e) {
                int mid = (s + e) / 2;
                long dis = Math.abs(arr[mid] - animal[i][0]) + animal[i][1];
                
                if(dis <= l) {
                    cnt++;
                    break;
                }
                
                if(animal[i][0] < arr[mid]) {
                    e = mid-1;
                } else {
                    s = mid+1;
                }
            }
        }
        
        System.out.print(cnt);
    }
}
