import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Room[] room;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            n = Integer.parseInt(br.readLine());

            if(n == 0) break;
            room = new Room[n+1];
            for(int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                room[i] = new Room(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));

                while(true) {
                    int num = Integer.parseInt(st.nextToken());
                    if(num == 0) break;
                    room[i].list.add(num);
                }
            }

            if(go(1)) sb.append("Yes\n");
            else sb.append("No\n");

        }

        System.out.print(sb);
    }

    static boolean go(int now) {
        Queue<int[]> q = new ArrayDeque<>();
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        q.add(new int[]{now, 0});
        visited[1] = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            now = pos[0];
            int money = pos[1];

            if(room[now].status == 'T') {
                if(money < room[now].m) continue;
                money -= room[now].m;
            } else if(room[now].status == 'L') {
                if(money < room[now].m) money = room[now].m;
            }

            if(now == n) return true;

            for(int next : room[now].list) {
                if(visited[next] >= money) continue;
                visited[next] = money;
                q.add(new int[]{next, money});
            }
        }

        return false;
    }

    static class Room {
        char status;
        int m;
        List<Integer> list;

        Room(char status, int m){
            this.status = status;
            this.m = m;
            this.list = new ArrayList<>();
        }
    }
}
