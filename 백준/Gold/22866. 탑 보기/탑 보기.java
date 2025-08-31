import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] cnt = new int[n+1];
        int[] near = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            near[i] = -100000;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            cnt[i] = stack.size();
            if(cnt[i] > 0) near[i] = stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        for(int i = n; i > 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            int s = stack.size();
            cnt[i] += s;
            if(s > 0 && stack.peek() - i < i - near[i]) near[i] = stack.peek();
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(cnt[i]);
            if(cnt[i] > 0) {
                sb.append(" ").append(near[i]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
