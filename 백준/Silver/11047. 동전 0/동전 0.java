import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = n-1; i >= 0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int idx = 0;
        while(k > 0) {
            cnt += (k / arr[idx]);
            k %= arr[idx];
            idx++;
        }

        System.out.print(cnt);
    }
}
