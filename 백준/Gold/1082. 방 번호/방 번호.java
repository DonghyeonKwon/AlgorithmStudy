import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Num[] arr = new Num[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            arr[i] = new Num(i, Integer.parseInt(st.nextToken()));
            map.put(i, arr[i].cost);
        }

        Arrays.sort(arr);

        int cnt = 0;
        int[] res = new int[51];
        if(arr[0].idx == 0) {
            if(n == 1 || arr[1].cost > m) {
                System.out.print(0);
                return;
            }
            res[cnt++] = arr[1].idx;
            m -= arr[1].cost;
        }

        while(m - arr[0].cost >= 0) {
            res[cnt++] = arr[0].idx;
            m -= arr[0].cost;
        }

        for(int i = 0; i < cnt; i++) {
            for(int j = n-1; j >= 0; j--) {
                if(i == 0 && j == 0) continue;
                int tmp = m + map.get(res[i]) - map.get(j);
                if(tmp >= 0) {
                    m = tmp;
                    res[i] = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cnt; i++) {
            sb.append(res[i]);
        }

        System.out.print(sb);
    }

    static class Num implements Comparable<Num>{
        int idx;
        int cost;

        Num(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Num o) {
            if(this.cost == o.cost) {
                return o.idx - this.idx;
            }
            return this.cost - o.cost;
        }
    }
}
