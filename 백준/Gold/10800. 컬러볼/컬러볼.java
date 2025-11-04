import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        User[] arr = new User[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            arr[i] = new User(i, color, size);
        }

        Arrays.sort(arr);
        int idx = 0;
        int sum = 0;
        int[] ans = new int[n];
        int[] colors = new int[n+1];
        for(int i = 0; i < n; i++) {
            User curr = arr[i];
            while(arr[idx].size < curr.size) {
                sum += arr[idx].size;
                colors[arr[idx].color] += arr[idx].size;
                idx++;
            }
            ans[curr.idx] = sum - colors[curr.color];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n ; i++) {
            sb.append(ans[i] + "\n");
        }
        System.out.print(sb);
    }

    static class User implements Comparable<User> {
        int idx, color, size;

        User(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }

        @Override
        public int compareTo(User o) {
            return this.size - o.size;
        }
    }
}
