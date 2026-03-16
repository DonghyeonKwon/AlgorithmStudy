import java.io.*;
import java.util.*;

public class Main {
    static int X;
    static int[] arr;
    static int[] ans;
    static int[] visited;
    static boolean flag = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[X];
        ans = new int[2 * X];
        visited = new int[17];
        for(int i = 0; i < X; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Arrays.fill(ans, -1);

        dfs(0);

        if(flag) System.out.print(-1);
    }

    static void dfs(int idx) {
        if(idx == 2 * X) {
            for(int i = 0; i < 2 * X; i++) {
                System.out.print(ans[i] + " ");
            }
            flag = false;
            return;
        }

        for(int i = 0; flag && i < X; i++) {
            if(visited[arr[i]] >= 2) continue;
            if(visited[arr[i]] == 1 && (idx - arr[i] - 1 < 0 || ans[idx-arr[i] - 1] != arr[i])) continue;
            ans[idx] = arr[i];
            visited[arr[i]]++;
            dfs(idx + 1);
            visited[arr[i]]--;
            ans[idx] = -1;
        }
    }
}
