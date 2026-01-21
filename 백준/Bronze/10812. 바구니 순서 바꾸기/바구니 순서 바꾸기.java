import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new ArrayDeque<>();
            for(int j = c; j <= b; j++) {
                q.add(arr[j]);
            }

            for(int j = a; j < c; j++) {
                q.add(arr[j]);
            }

            for(int j = a; j <= b; j++) {
                arr[j] = q.poll();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.print(sb);
    }
}
