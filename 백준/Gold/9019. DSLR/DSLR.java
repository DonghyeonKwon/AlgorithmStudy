import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            bw.write(bfs(num, dest));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String bfs(int num, int dest) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        String[] answer = new String[10000];
        q.add(num);
        answer[num] = "";
        visited[num] = true;
        char[] arr = {'D', 'S', 'L', 'R'};

        while(!q.isEmpty() && !visited[dest]) {
            int now = q.poll();

            int D = (now * 2) % 10000;
            int S = now== 0 ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now / 10) + (now % 10) * 1000;

            if(!visited[D]) {
                q.add(D);
                visited[D] = true;
                answer[D] = answer[now] + 'D';
            }

            if(!visited[S]) {
                q.add(S);
                visited[S] = true;
                answer[S] = answer[now] + 'S';
            }

            if(!visited[L]) {
                q.add(L);
                visited[L] = true;
                answer[L] = answer[now] + 'L';
            }

            if(!visited[R]) {
                q.add(R);
                visited[R] = true;
                answer[R] = answer[now] + 'R';
            }
        }

        return answer[dest] + '\n';
    }
}
