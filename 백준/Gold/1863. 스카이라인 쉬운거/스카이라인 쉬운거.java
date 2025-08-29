import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        for(int i = 0; i <n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        int answer = 0;

        for(int h : height) {
            if(h == 0) {
                answer += stk.size();
                stk.clear();
            }
            else if(!stk.isEmpty()) {
                int peek = stk.peek();
                if(peek < h) {
                    stk.push(h);
                } else {
                    while(!stk.isEmpty() && stk.peek() > h) {
                        stk.pop();
                        answer++;
                    }

                    if(!stk.isEmpty() && stk.peek() < h) {
                        stk.push(h);
                    }
                    if(stk.isEmpty()) {
                        stk.push(h);
                    }
                }
            } else {
                stk.push(h);
            }
        }

        answer += stk.size();

        System.out.print(answer);
    }
}
