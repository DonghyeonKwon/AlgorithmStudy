import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int max = 0, cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = x; i <= n; i++) {
            int num = arr[i] - arr[i-x];

            if(max < num) {
                cnt = 1;
                max = num;
            } else if(max == num) {
                cnt++;
            }
        }

        if(max == 0) {
            System.out.print("SAD");
            return;
        }
        System.out.print(max + "\n" + cnt);
    }
}
