import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stk = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+') {
                double b = stk.pop();
                double a = stk.pop();
                a += b;
                stk.push(a);
            } else if(c == '-') {
                double b = stk.pop();
                double a = stk.pop();
                a -= b;
                stk.push(a);
            } else if(c == '*') {
                double b = stk.pop();
                double a = stk.pop();
                a *= b;
                stk.push(a);
            } else if(c == '/') {
                double b = stk.pop();
                double a = stk.pop();
                a /= b;
                stk.push(a);
            } else {
                stk.push((double) arr[c - 'A']);
            }
        }

        System.out.printf("%.2f", stk.pop());
    }
}
