import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        while(t-->0) {
            String[] input = br.readLine().split(" ");

            if(input[0].equals("push")) {
                stk.push(Integer.parseInt(input[1]));
                continue;
            } else if(input[0].equals("pop")) {
                sb.append(stk.isEmpty() ? -1 : stk.pop());
            } else if(input[0].equals("size")) {
                sb.append(stk.size());
            } else if(input[0].equals("empty")) {
                sb.append(stk.isEmpty() ? 1 : 0);
            } else if(input[0].equals("top")) {
                sb.append(stk.isEmpty() ? -1 : stk.peek());
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
