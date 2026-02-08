import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Rule[] rules = new Rule[k];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            rules[i] = new Rule(a, b, c);
        }

        int l = 1;
        int r = n;
        int ans = 1;
        while(l <= r) {
            int mid = (l + r) / 2;

            long total = 0;
            for(int i = 0; i < k; i++) {
                int b = Math.min(mid, rules[i].b);
                if(rules[i].a <= b) {
                    total += ((b - rules[i].a) / rules[i].c) + 1;
                }
            }

            if(total >= d) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.print(ans);
    }

    static class Rule {
        int a, b, c;

        Rule(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
