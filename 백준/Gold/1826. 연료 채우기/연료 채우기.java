import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Integer> fuelPQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.add(new Node(a, b));
        }

        String[] input = br.readLine().split(" ");
        int l = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        int ans = 0;

        while(p < l) {
            while(!pq.isEmpty() && pq.peek().a <= p) {
                fuelPQ.add(pq.poll().b);
            }

            if(fuelPQ.isEmpty()) {
                ans = -1;
                break;
            }

            ans++;
            p += fuelPQ.poll();
        }

        System.out.print(ans);
    }

    static class Node implements Comparable<Node>{
        int a, b;

        Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return this.a - o.a;
        }
    }
}
