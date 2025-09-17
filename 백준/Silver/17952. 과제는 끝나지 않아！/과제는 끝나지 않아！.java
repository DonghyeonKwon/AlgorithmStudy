import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        Stack<int[]> stk = new Stack<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            if(k == 0) {
                if(!stk.isEmpty()) {
                    stk.peek()[1]--;
                }
            } else {
                stk.push(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1});
            }

            if(!stk.isEmpty() && stk.peek()[1] == 0) {
                ans += stk.pop()[0];
            }
        }

        System.out.print(ans);
    }
}
