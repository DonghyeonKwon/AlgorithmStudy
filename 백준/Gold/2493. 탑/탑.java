import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        Stack<int[]> stk = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            stk.push(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        Stack<int[]> temp = new Stack<>();
        while(!stk.isEmpty()) {
            if(temp.isEmpty()) {
                temp.push(stk.pop());
                continue;
            }

            if(stk.peek()[1] < temp.peek()[1]) {
                temp.push(stk.pop());
                continue;
            }

            while(!temp.isEmpty() && stk.peek()[1] >= temp.peek()[1]) {
                int[] a = temp.pop();
                answer[a[0]] = stk.peek()[0] + 1;
            }
        }

        while(!temp.isEmpty()) {
            int[] a = temp.pop();
            answer[a[0]] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.print(sb);
    }
}
