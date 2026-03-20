import java.io.*;
import java.util.*;

public class Main {
    static Trie root;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num = "";
        while((num = br.readLine()) != null && !num.isEmpty()) {
            root = new Trie();
            int n = Integer.parseInt(num);
            for(int i = 0; i < n; i++) {
                char[] arr = br.readLine().toCharArray();
                root.inputWord(arr, arr.length);
            }

            int sum = 0;
            for(int i = 0; i < 27; i++) {
                if((root.visited & (1 << i)) == 0) continue;
                sum += root.cnt2[i];
                sum += root.next[i].getSum();
            }

            sb.append(String.format("%.2f", (double)sum / n)).append('\n');
        }

        System.out.print(sb);
    }

    static class Trie {
        boolean isFinish;
        int visited;
        int[] cnt2;
        int cnt;
        Trie[] next;

        Trie() {
            this.visited = 0;
            this.cnt = 0;
            this.cnt2 = new int[26];
            this.next = new Trie[26];
            this.isFinish = false;
        }

        void inputWord(char[] arr, int n) {
            Trie iter = this;
            for(int i = 0; i < n; i++) {
                int idx = arr[i] - 'a';
                if((iter.visited & (1 << idx)) == 0) {
                    iter.visited |= (1 << idx);
                    iter.cnt++;
                    iter.next[idx] = new Trie();
                }
                iter.cnt2[idx]++;
                iter = iter.next[idx];
            }

            iter.isFinish = true;
        }

        int getSum() {
            if(this.cnt == 0 && this.isFinish) return 0;
            int sum = 0;

            if(this.cnt == 1) {
                for(int i = 0; i < 26; i++) {
                    if((visited & (1 << i)) > 0) {
                        return this.next[i].getSum() + (this.isFinish ? this.cnt2[i] : 0);
                    }
                }
            }

            for(int i = 0; i < 26; i++) {
                if((visited & (1 << i)) == 0) continue;
                sum += cnt2[i];
                sum += this.next[i].getSum();

                int tmp = visited >> i;
                if(tmp == 0) break;
            }

            return sum;
        }
    }
}
