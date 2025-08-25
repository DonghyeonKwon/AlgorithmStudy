import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if(k == 1) {
                sb.append("1 1\n");
                continue;
            }

            int max = -1;
            int min = 1000000;
            int[] alpha = new int[26];
            for(int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i) - 'a']++;
            }

            for(int i = 0; i < str.length(); i++) {
                if(alpha[str.charAt(i) - 'a'] < k) continue;

                int cnt = 1;
                for(int j = i+1; j < str.length(); j++) {
                    if(str.charAt(i) == str.charAt(j)) cnt++;
                    if(cnt == k) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }

            if(max == -1 || min == 1000000) {
                sb.append(-1 + "\n");
            } else {
                sb.append(min + " " + max + "\n");
            }
        }

        System.out.print(sb);
    }
}
