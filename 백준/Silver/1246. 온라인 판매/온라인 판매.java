import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;
        int price = 0;

        for(int i = 0; i < m; i++) {
            int p = m - i;
            if(p > n) p = n;
            if(max < arr[i] * p) {
                price = arr[i];
                max = arr[i] * p;
            }
        }

        System.out.print(price + " " + max);
    }
}
