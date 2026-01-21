import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] input = br.readLine().split(",");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        n--;

        while(k-- > 0) {
            int[] temp = new int[n];

            for(int i = 0; i < n; i++) {
                temp[i] = arr[i+1] - arr[i];
            }

            arr = temp;
            n--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n+1; i++) {
            sb.append(arr[i]).append(i == n ? '\n' : ',');
        }

        System.out.print(sb);
    }
}
