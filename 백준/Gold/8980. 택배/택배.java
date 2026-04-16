import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int[] town = new int[n+1];
        Box[] arr = new Box[k];
        int res = 0;


        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr[i] = new Box(from, to, m);
        }

        Arrays.sort(arr);
        Arrays.fill(town, c);

        for(int i = 0; i < k; i++) {
            Box b = arr[i];

            int min = Integer.MAX_VALUE;
            for(int j = b.from; j < b.to; j++) {
                min = Math.min(min, town[j]);
            }

            if(min >= b.m) {
                for(int j = b.from; j < b.to; j++) {
                    town[j] -= b.m;
                }
                res += b.m;
            } else {
                for(int j = b.from; j < b.to; j++) {
                    town[j] -= min;
                }
                res += min;
            }
        }

        System.out.print(res);
    }

    static class Box implements Comparable<Box>{
        int from;
        int to;
        int m;

        Box(int from, int to, int m) {
            this.from = from;
            this.to = to;
            this.m = m;
        }

        @Override
        public int compareTo(Box o) {
            if(this.to == o.to) {
                return this.from - o.from;
            }

            return this.to - o.to;
        }
    }
}
