import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] hList;
    static List<Integer>[] sList;
    static int[] answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        hList = new ArrayList[n+1];
        sList = new ArrayList[n+1];
        answer = new int[n+1];

        for(int i = 1; i <= n; i++) {
            hList[i] = new ArrayList<>();
            sList[i] = new ArrayList<>();
            answer[i] = n-1;
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            hList[a].add(b);
            sList[b].add(a);
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            int a = heavyDfs(i);
            answer[i] -= a;
            a = softDfs(i);
            answer[i] -= a;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(answer[i]).append('\n');
        }

        System.out.print(sb);
    }

    static int heavyDfs(int now) {
        int cnt = 0;

        for(int next : hList[now]) {
            if(visited[next]) continue;
            visited[next] = true;
            cnt++;
            cnt += heavyDfs(next);
        }

        return cnt;
    }

    static int softDfs(int now) {
        int cnt = 0;

        for(int next : sList[now]) {
            if(visited[next]) continue;
            visited[next] = true;
            cnt++;
            cnt += softDfs(next);
        }

        return cnt;
    }
}
