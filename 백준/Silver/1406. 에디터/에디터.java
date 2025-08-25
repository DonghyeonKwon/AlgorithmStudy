import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> front = new Stack<>();
        Stack<Character> back = new Stack<>();
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++) {
            front.add(input.charAt(i));
        }


        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String str = br.readLine();

            if(str.charAt(0) == 'L') {
                if(front.isEmpty()) continue;
                back.add(front.pop());
            } else if(str.charAt(0) == 'D') {
                if(back.isEmpty()) continue;
                front.add(back.pop());
            } else if(str.charAt(0) == 'B') {
                if(!front.isEmpty()) front.pop();
            } else if(str.charAt(0) == 'P') {
                front.add(str.charAt(2));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!front.isEmpty()) {
            sb.append(front.pop());
        }
        sb.reverse();

        while(!back.isEmpty()) {
            sb.append(back.pop());
        }

        System.out.print(sb);
    }
}
