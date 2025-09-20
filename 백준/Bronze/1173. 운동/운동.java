import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        if(M - m < T) {
            System.out.print(-1);
            return;
        }
        
        int X = m;
        int time = 0;
        while(true) {
            if(X + T <= M) {
                X += T;
                N--;
            } else {
                X -= R;
            }

            if(X < m) {
                X = m;
            }

            time++;
            if(N == 0) break;
        }

        System.out.print(time);
    }
}
