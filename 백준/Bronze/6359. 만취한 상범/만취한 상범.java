import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            boolean[] room = new boolean[n+1];

            for(int i = 2; i <= n; i++) {
                int idx = 1;
                while(i * idx <= n) {
                    room[i * idx] ^= true;
                    idx++;
                }
            }

            int cnt = 0;
            for(int i = 1; i <= n; i++) {
                if(!room[i]) cnt++;
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}
