import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = -1;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < 4; j++) {
                int p = Integer.parseInt(st.nextToken());
                map.put(p, map.getOrDefault(p, 0) + 1);
            }

            int num = 0;
            int cnt = 0;

            for(int key : map.keySet()) {
                if(cnt < map.get(key)) {
                    cnt = map.get(key);
                    num = key;
                } else if(cnt == map.get(key)) {
                    num = key;
                }
            }

            if(cnt == 1) {
                ans = Math.max(ans, num * 100);
            } else if(cnt == 2) {
                int c = 0;
                int k = 0;
                for(int key : map.keySet()) {
                    if(key != num){
                        c++;
                        k = key;
                    }
                }

                if(c == 1) {
                    ans = Math.max(ans, 2000 + k * 500 + num * 500);
                } else {
                    ans = Math.max(ans, 1000 + num * 100);
                }
            } else if(cnt == 3) {
                ans = Math.max(ans, 10000 + num * 1000);
            } else {
                ans = Math.max(ans, 50000 + num * 5000);
            }
        }

        System.out.print(ans);
    }
}
