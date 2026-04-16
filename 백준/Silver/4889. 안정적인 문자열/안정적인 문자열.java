import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = 1;
        while(true) {
            String input = br.readLine();

            if(input.charAt(0) == '-') break;

            int cnt = 0;
            Stack<Character> stk = new Stack<>();

            for(int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '{') {
                    stk.push('{');
                } else {
                    if(stk.isEmpty()) {
                        cnt++;
                        stk.push('{');
                    } else {
                        stk.pop();
                    }
                }
            }

            cnt += stk.size() / 2;

            sb.append(t).append(". ").append(cnt).append('\n');
            t++;
        }

        System.out.print(sb);
    }
}
