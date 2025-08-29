import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<String> list = new ArrayList<>();
    static String[] op = {"+", "-", " "};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            go(1, "1");

            if(t > 0) sb.append("\n\n");

            Collections.sort(list);
            for(int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if(i < list.size() - 1) sb.append('\n');
            }
        }

        System.out.print(sb);
    }

    static void go(int idx, String str) {
        if(idx == n) {
            String s = str.replaceAll(" ", "");

            StringTokenizer st = new StringTokenizer(s, "-|+", true);
            int sum = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                String o = st.nextToken();
                if(o.equals("+")) {
                    sum += Integer.parseInt(st.nextToken());
                } else {
                    sum -= Integer.parseInt(st.nextToken());
                }
            }

            if(sum == 0) {
                list.add(str);
            }

            return;
        }

        for(int i = 0; i < 3; i++) {
            go(idx + 1, str + op[i] + (idx+1));
        }
    }
}
