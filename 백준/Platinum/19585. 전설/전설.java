import java.io.*;
import java.util.*;

public class Main {
    static Trie trie = new Trie();
    static Set<String> set = new HashSet<>();
    static int cMin = 1001, cMax = 0, nMin = 1001, nMax = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < c; i++) {
            String color = br.readLine();
            int len = color.length();
            cMin = Math.min(len, cMin);
            cMax = Math.max(len, cMax);

            Trie temp = trie;
            for(int j = 0; j < color.length(); j++) {
                temp = temp.addAndGetChild(color.charAt(j));
            }
            temp.setEnd();
        }

        for(int i = 0; i < n; i++) {
            String name = br.readLine();
            int len = name.length();
            nMin = Math.min(len, nMin);
            nMax = Math.max(len, nMax);
            set.add(name);
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            String input = br.readLine();
            int len = input.length();
            boolean flag = len > cMax + nMax ? false : check(input);
            sb.append(flag ? "Yes\n" : "No\n");
        }

        System.out.print(sb);
    }

    static boolean check(String input) {
        Trie temp = trie;
        int len = input.length();
        for(int i = 0; i < len; i++) {
            if(len - i < nMin) break;
            temp = temp.getChild(input.charAt(i));
            if(temp == null) break;
            if(temp.isFinish && set.contains(input.substring(i+1))) return true;
        }

        return false;
    }

    static class Trie {
        boolean isFinish;
        Trie[] child;

        Trie() {
            isFinish = false;
            child = new Trie[26];
        }

        Trie addAndGetChild(char c) {
            if(child[c-'a'] == null) child[c-'a'] = new Trie();
            return child[c-'a'];
        }

        Trie getChild(char c) {
            return child[c-'a'];
        }

        void setEnd() {
            this.isFinish = true;
        }
    }
}
