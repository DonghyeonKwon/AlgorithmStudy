import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] drr = new int[n+1];
        int[] srr = new int[n+1];
        int[] prr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            srr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            drr[i] = Integer.parseInt(st.nextToken());
        }

        while(k-- > 0) {

            for(int i = 1; i <= n; i++) {
                prr[drr[i]] = srr[i];
            }

            for(int i = 1; i <= n; i++) {
                srr[i] = prr[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(prr[i]).append(' ');
        }

        System.out.print(sb);
    }
}
