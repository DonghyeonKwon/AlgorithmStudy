import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] matrix;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(go());
    }

    static int go() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int ret = 0;
        visited = new boolean[1 << n][n];
        pq.add(new int[]{k, 0, 1 << k});

        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int now = arr[0];
            if(visited[arr[2]][now]) continue;

            visited[arr[2] | (1 << now)][now] = true;
            if(arr[2] == (1 << n) - 1) {
                ret = arr[1];
                break;
            }

            for(int i = 0; i < n; i++) {
                if(i != now && !visited[arr[2] | (1 << i)][i]) {
                    pq.add(new int[]{i, arr[1] + matrix[now][i], arr[2] | (1 << i)});
                }
            }
        }

        return ret;
    }
}
