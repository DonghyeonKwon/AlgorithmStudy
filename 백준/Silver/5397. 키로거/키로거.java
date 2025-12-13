import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            Deque<Character> front = new ArrayDeque<>();
            Deque<Character> back = new ArrayDeque<>();

            String input = br.readLine();

            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == '<') {
                    if(front.isEmpty()) continue;
                    back.addFirst(front.pollLast());
                } else if(c == '>') {
                    if(back.isEmpty()) continue;
                    front.addLast(back.pollFirst());
                } else if(c == '-') {
                    if(front.isEmpty()) continue;
                    front.pollLast();
                } else {
                    front.addLast(c);
                }
            }

            while(!front.isEmpty()) {
                sb.append(front.pollFirst());
            }
            while(!back.isEmpty()) {
                sb.append(back.pollFirst());
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
