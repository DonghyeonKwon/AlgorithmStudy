import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            Trie tree = new Trie();

            int n = Integer.parseInt(br.readLine());

            boolean flag = false;
            String[] input = new String[n];
            for(int i = 0; i < n; i++) {
                input[i] = br.readLine();
            }

            for(int i = 0; !flag && i < n; i++) {
                flag = dfs(0, input[i], tree);
            }

            if(flag) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.print(sb);
    }

    static boolean dfs(int idx, String input, Trie tree) {
        if(tree.finish) {
            return true;
        }

        if(idx == input.length()) {
            tree.finish = true;
            return !tree.map.isEmpty();
        }

        Trie next;
        if(tree.map.containsKey(input.charAt(idx))) {
            next = tree.map.get(input.charAt(idx));
        } else {
            next = new Trie();
            tree.map.put(input.charAt(idx), next);
        }

        return dfs(idx + 1, input, next);
    }

    static class Trie {
        boolean finish;
        Map<Character, Trie> map;

        Trie() {
            this.finish = false;
            this.map = new HashMap<>();
        }
    }
}
