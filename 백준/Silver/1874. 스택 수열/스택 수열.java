import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        int num = 1;
        StringBuilder sb = new StringBuilder();
        while(idx < n && num <= n + 1) {
            if(!stk.isEmpty() && stk.peek() == arr[idx]) {
                stk.pop();
                idx++;
                sb.append("-\n");
                continue;
            }

            stk.push(num++);
            sb.append("+\n");
        }

        if(stk.isEmpty()) {
            System.out.print(sb);
        } else {
            System.out.print("NO\n");
        }
    }
}
