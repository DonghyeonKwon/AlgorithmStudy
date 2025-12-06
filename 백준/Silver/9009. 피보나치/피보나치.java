import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        init();

        while(n-->0) {
            int input = Integer.parseInt(br.readLine());

            dfs(list.size() - 1, input);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean dfs(int idx, int num) {
        if(num == 0) {
            return true;
        }

        for(int i = idx; i >= 0; i--) {
            if(num - list.get(i) < 0) continue;
            if(dfs(i - 1, num - list.get(i))) {
                sb.append(list.get(i)).append(' ');
                return true;
            }
        }

        return false;
    }

    static void init() {
        list.add(0);
        list.add(1);

        int a = 0;
        while((a = list.get(list.size() - 1) + list.get(list.size() - 2)) < 1_000_000_000) {
            list.add(a);
        }
    }
}
