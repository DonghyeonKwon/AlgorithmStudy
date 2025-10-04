import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n == 0) {
            System.out.print(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int prev = arr[0];

        for(int i = 1; i < n; i++) {
            if(prev + arr[i] <= m) {
                prev += arr[i];
            } else {
                cnt++;
                prev = arr[i];
            }
        }

        cnt++;
        System.out.print(cnt);
    }
}
