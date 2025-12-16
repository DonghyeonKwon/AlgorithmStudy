import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stk = new Stack<>();
        String input = br.readLine();
        int n = input.length();

        int cnt = 0;
        int ans = 0;
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            char c = input.charAt(i);

            if(c == '(') {
                stk.push(c);
            } else {
                stk.pop();
                if(input.charAt(i - 1) == '(') {
                    ans += stk.size();
                } else {
                    ans++;
                }
            }

        }

        System.out.print(ans);
    }
}
