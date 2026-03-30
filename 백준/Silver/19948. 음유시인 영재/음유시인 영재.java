import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int space = Integer.parseInt(br.readLine());

        int[] cnt = new int[26];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 26; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        boolean title = true;
        boolean ans = true;
        char prev = '-';
        for(int i = 0; ans && i < arr.length; i++) {
            if(Character.toLowerCase(prev) == Character.toLowerCase(arr[i])) continue;
            prev = arr[i];

            if(arr[i] == ' ') {
                if(space > 0) {
                    space--;
                    title = true;
                } else ans = false;

                continue;
            }

            int idx = 'A' <= arr[i] && arr[i] <= 'Z' ? arr[i] - 'A' : arr[i] - 'a';
            if(cnt[idx] > 0) {
                cnt[idx]--;
            } else {
                ans = false;
                continue;
            }

            if(title) {
                if(cnt[idx] > 0) {
                    cnt[idx]--;
                } else {
                    ans = false;
                    continue;
                }
                char c = (char)('A' + idx);
                sb.append(c);
                title = false;
            }
        }

        System.out.print(ans ? sb : -1);
    }
}
