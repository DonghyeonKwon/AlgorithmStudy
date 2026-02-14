import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] cnt0 = new int[41];
        int[] cnt1 = new int[41];
        cnt0[0] = 1;
        cnt1[1] = 1;

        for(int i = 2; i <= 40; i++) {
            cnt0[i] = cnt0[i-1] + cnt0[i-2];
            cnt1[i] = cnt1[i-1] + cnt1[i-2];
        }

        int t = Integer.parseInt(br.readLine());

        while(t-->0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(cnt0[n]).append(' ').append(cnt1[n]).append('\n');
        }

        System.out.print(sb);
    }
}
