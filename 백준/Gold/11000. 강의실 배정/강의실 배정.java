import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr,
                (a, b) -> {
                    if(a[0] == b[0]) return a[1] - b[1];
                    return a[0] - b[0];
                }
        );

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);

        for(int i = 1; i < n; i++) {
            if(pq.peek() > arr[i][0]) {
                pq.add(arr[i][1]);
            } else {
                pq.poll();
                pq.add(arr[i][1]);
            }
        }

        System.out.print(pq.size());
    }
}
