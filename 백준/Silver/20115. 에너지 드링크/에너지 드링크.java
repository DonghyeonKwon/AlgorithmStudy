import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Double> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            pq.add(Double.parseDouble(st.nextToken()));
        }

        double sum = 0;
        while(pq.size() > 1) {
            sum += (pq.poll() / 2);
        }

        sum += pq.poll();
        sum = (double) Math.round(sum * 10000) / 10000;

        System.out.print(sum);
    }
}
