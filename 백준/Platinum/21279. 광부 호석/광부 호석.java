import java.io.*;
import java.util.*;

public class Main {
    static int n, c;
    static List<Info> list = new ArrayList<>();
    static List<Info>[] arrList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int maxY = 0, maxX = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            maxY = Math.max(y, maxY);
            maxX = Math.max(x, maxX);

            list.add(new Info(y, x, cost));
        }

        arrList = new ArrayList[maxX + 1];
        for(int i = 0; i <= maxX; i++) arrList[i] = new ArrayList<>();
        for(Info k : list) {
            arrList[k.x].add(k);
        }

        long ans = 0, sum = 0;
        int nowY = maxY;
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> b.y - a.y);

        for(int x = 0; x <= maxX; x++) {
            if(arrList[x].isEmpty()) continue;

            for(Info i : arrList[x]) {
                if(i.y <= nowY) {
                    pq.add(i);
                    sum += i.cost;
                }
            }

            while(pq.size() > c) {
                int max = pq.peek().y;

                while(!pq.isEmpty() && max == pq.peek().y) {
                    sum -= pq.poll().cost;
                }
                nowY = max;
            }

            ans = Math.max(ans, sum);
        }

        System.out.print(ans);
    }

    static class Info {
        int y, x, cost;

        Info(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
