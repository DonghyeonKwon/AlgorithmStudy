import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int tmp = a % 10;
            List<Integer> list = new ArrayList<>();
            list.add(tmp);
            while(true) {
                tmp *= a;
                tmp %= 10;
                if(list.get(0) == tmp) break;
                list.add(tmp);
            }

            if(list.size() == 1) {
                sb.append(list.get(0) == 0 ? 10 : list.get(0)).append('\n');
                continue;
            }

            int k = b % list.size() - 1;
            if(k < 0) k = list.size()-1;
            sb.append(list.get(k) == 0 ? 10 : list.get(k)).append('\n');
        }

        System.out.println(sb);
    }
}
