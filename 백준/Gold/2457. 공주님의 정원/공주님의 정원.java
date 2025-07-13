import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = 3 * 100 + 1;
        int end = 12 * 100 + 1;

        int n = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(sm * 100 + sd, em * 100 + ed);
        }

        Arrays.sort(flowers, (o1, o2) -> {
            if(o1.start == o2.start) return o2.end - o1.end;
            return o1.start - o2.start;
        });

        int idx = 0, max = 0, answer = 0;
        while(start < end) {
            boolean isFind = false;
            for(int i = idx; i < n; i++) {
                if(flowers[i].start > start) break;

                if(flowers[i].end > max) {
                    max = flowers[i].end;
                    isFind = true;
                    idx = i + 1;
                }
            }

            if(isFind){
                answer++;
                start = max;
            } else break;
        }

        if(max < end) System.out.print(0);
        else System.out.print(answer);
    }

    static class Flower {
        int start, end;

        Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
