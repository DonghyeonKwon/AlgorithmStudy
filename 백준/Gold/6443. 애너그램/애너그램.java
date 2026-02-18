import java.io.*;
import java.util.*;

public class Main {
    static List<String> list = new ArrayList<>();
    static char[] temp;
    static int[] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            list.clear();

            char[] arr = br.readLine().toCharArray();
            temp = new char[arr.length];
            cnt = new int[26];
            for(char c : arr) {
                cnt[c - 'a'] += 1;
            }

            dfs(0);

            Collections.sort(list);

            String prev = list.get(0);
            sb.append(prev).append('\n');
            for(int i = 1; i < list.size(); i++) {
                String now = list.get(i);
                if(prev.equals(now)) continue;
                sb.append(now).append('\n');
                prev = now;
            }
        }

        System.out.print(sb);
    }

    static void dfs(int idx) {
        if(idx == temp.length) {
            list.add(String.valueOf(temp));
            return;
        }

        for(int i = 0; i < 26; i++) {
            if(cnt[i] > 0) {
                temp[idx] = (char)('a' + i);
                cnt[i] -= 1;
                dfs(idx + 1);
                cnt[i] += 1;
            }
        }
    }
}
