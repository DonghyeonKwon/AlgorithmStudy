import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(b == 0) {
                cnt += stk.size();
                stk.clear();
            } else if(!stk.isEmpty()){
                int peek = stk.peek();
                
                if(peek < b) {
                    stk.push(b);
                } else {
                    while(!stk.isEmpty() && stk.peek() > b) {
                        stk.pop();
                        cnt++;
                    }
                    
                    if(!stk.isEmpty() && stk.peek() < b) {
                        stk.push(b);
                    }
                    
                    if(stk.isEmpty()) {
                        stk.push(b);
                    }
                }
            } else {
                stk.push(b);
            }
                
        }

        cnt += stk.size();
        System.out.println(cnt);
    }
}
