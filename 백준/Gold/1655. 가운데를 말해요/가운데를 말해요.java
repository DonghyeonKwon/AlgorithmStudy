import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(
                (a, b) -> b - a
        );

        StringBuilder sb = new StringBuilder();
        while(n-->0) {
            int num = Integer.parseInt(br.readLine());
            if(maxPQ.size() == minPQ.size()) maxPQ.add(num);
            else minPQ.add(num);
            
            if(!maxPQ.isEmpty() && !minPQ.isEmpty()) {
                if(maxPQ.peek() > minPQ.peek()) {
                    int tmp = maxPQ.poll();
                    maxPQ.add(minPQ.poll());
                    minPQ.add(tmp);
                }
            }

            sb.append(maxPQ.peek()).append('\n');
        }

        System.out.print(sb);
    }
}
