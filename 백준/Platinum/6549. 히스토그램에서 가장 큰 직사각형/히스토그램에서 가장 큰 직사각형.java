import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long max = go(n);

            bw.write(Long.toString(max));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static long go(int len) {
        Stack<Integer> stk = new Stack<>();

        long max = 0;

        for(int i = 0; i < len; i++) {

            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                int h = arr[stk.pop()];

                long w = stk.isEmpty() ? i : i - 1 - stk.peek();

                max = Math.max(max, w * h);
            }

            stk.push(i);
        }

        while(!stk.isEmpty()) {
            int h = arr[stk.pop()];

            long w = stk.isEmpty() ? len : len - 1 - stk.peek();
            max = Math.max(max, w * h);
        }

        return max;
    }
}
