import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        Stack<Character> stk = new Stack<>();
        boolean flag = false;

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '<') {
                while(!stk.isEmpty()) {
                    sb.append(stk.pop());
                }
                flag = true;
                sb.append(c);
            } else if(c == '>') {
                flag = false;
                sb.append(c);
            } else if(c == ' ') {
                while(!stk.isEmpty()) {
                    sb.append(stk.pop());
                }
                sb.append(c);
            } else {
                if(flag) {
                    sb.append(c);
                } else {
                    stk.push(c);
                }
            }
        }

        while(!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        System.out.print(sb);
    }
}
