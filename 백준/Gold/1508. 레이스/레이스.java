import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] position;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        position = new int[k];
        for(int i = 0; i < k; i++) {
            position[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(search());
    }

    static String search() {
        String res = "";

        int min = 1;
        int max = n;

        while(min <= max) {
            int mid = (min + max) / 2;
            String ans = check(mid);

            if(ans.isEmpty()) {
                max = mid - 1;
            } else {
                min = mid + 1;
                res = ans;
            }
        }

        return res;
    }

    static String check(int target) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        cnt += 1;
        int before = position[0];

        for(int i = 1; i < k; i++) {
            if(cnt == m) {
                sb.append(0);
            } else {
                if(position[i] - before >= target) {
                    sb.append(1);
                    cnt += 1;
                    before = position[i];
                } else {
                    sb.append(0);
                }
            }
        }

        if(cnt == m) {
            return sb.toString();
        }

        return "";
    }
}
