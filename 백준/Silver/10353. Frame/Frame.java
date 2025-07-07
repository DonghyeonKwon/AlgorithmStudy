import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int n, m, t;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            int k = Integer.parseInt(br.readLine());

            int sum = n + n + m + m - 4;

            if(k == 1) {
                sb.append("YES\n");
                continue;
            }

            if(n <= k && m <= k) {
                sb.append("NO\n");
                continue;
            }

            if(sum % k != 0) {
                sb.append("NO\n");
                continue;
            }

            boolean flag = false;

            if(n % k == 0 && (m - 2) % k == 0) flag = true;
            if(n % k == 1 && (m - 1) % k == 0) flag = true;
            if(m % k == 0 && (n - 2) % k == 0) flag = true;
            if(m % k == 1 && (n - 1) % k == 0) flag = true;
            if(n % k == 0 && (m - 1) % k == 0) {
                if((n - 1) % k == 0 && (m - 2) % k == 0) flag = true;
                if((m - 1) % k == 0 && (n - 2) % k == 0) flag = true;
            }
            if(m % k == 0 && (n - 1) % k == 0) {
                if((n - 1) % k == 0 && (m - 2) % k == 0) flag = true;
                if((m - 1) % k == 0 && (n - 2) % k == 0) flag = true;
            }

            if(flag) sb.append("YES\n");
            else sb.append("NO\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
