import java.io.*;
import java.util.*;

public class Main {
    static int k, n, f;
    static boolean flag;
    static boolean[][] relation;
    static boolean[] visited;
    static int[] friendCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        relation = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        friendCnt = new int[n+1];

        for(int i = 0; i < f; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b] = relation[b][a] = true;
            friendCnt[a]++;
            friendCnt[b]++;
        }

        for(int i = 1; i <= n; i++) {
            if(friendCnt[i] < (k - 1)) continue;
            if(flag) break;
            go(1, i);
        }

        if(!flag) System.out.print(-1);
    }

    static void go(int cnt, int idx) {
        visited[idx] = true;

        if(cnt == k) {
            flag = true;
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++) {
                if(visited[i]) sb.append(i).append('\n');
            }

            System.out.print(sb);

            return;
        }

        for(int i = idx + 1; i <= n; i++) {
            if(visited[i] || !relation[idx][i]) continue;
            if(flag) continue;
            if(checkFriend(i)) {
                go(cnt+1, i);
            }
        }

        visited[idx] = false;
    }

    static boolean checkFriend(int idx) {
        for(int i = 1; i <= n; i++) {
            if(visited[i] && !relation[i][idx]) return false;
        }

        return true;
    }
}
