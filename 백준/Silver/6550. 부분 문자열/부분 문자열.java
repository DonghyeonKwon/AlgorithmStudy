import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";
        while((input = br.readLine()) != null && !input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);

            String s = st.nextToken();
            String t = st.nextToken();

            if(s.length() > t.length()) {
                sb.append("No\n");
                continue;
            }

            if(s.equals(t)) {
                sb.append("Yes\n");
                continue;
            }

            int sIdx = 0;
            int tIdx = 0;

            while(sIdx < s.length() && tIdx < t.length()) {
                char sChar = s.charAt(sIdx);
                char tChar = t.charAt(tIdx);

                if(sChar == tChar) {
                    sIdx++;
                    tIdx++;
                    continue;
                }

                tIdx++;
            }

            if(sIdx == s.length()) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.print(sb);
    }
}
