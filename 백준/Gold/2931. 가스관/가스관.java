import java.util.*;
import java.io.*;

public class Main {
    static int r, c, cnt = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static char[] d = {'|', '-', '+', '1', '2', '3', '4'};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for(int i = 0; i < r; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                if(arr[j] != '.') cnt++;
                if(arr[j] == 'M' || arr[j] == 'Z') {
                    map[i][j] = '*';
                    continue;
                }
                map[i][j] = arr[j];
            }
        }

        loop : for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == '.'){
                    for(char a : d) {
                        map[i][j] = a;
                        visited = new boolean[r][c];
                        int ret = bfs(i, j);

                        if(ret == cnt+1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(i+1).append(" ").append(j+1).append(" ").append(a);
                            bw.write(sb.toString());
                            break loop;
                        }
                    }
                    map[i][j] = '.';
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int y, int x) {
        int vCnt = 1;
        visited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});

        boolean f = true;

        while(!q.isEmpty()){
            int[] pos = q.poll();
            y = pos[0];
            x = pos[1];

            //현재 위치에서 가는 방향 가져오기
            List<Integer> dist = getDist(map[y][x]);

            for(int i : dist){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= r || nx >= c) return -1;
                if(map[ny][nx] == '.') return -1;

                if(map[ny][nx] == '*') {
                    visited[ny][nx] = true;
                    vCnt++;
                    continue;
                }

                List<Integer> tDist = getDist(map[ny][nx]);
                boolean flag = false;

                //다음 블록의 갈 수 있는 방향의 반대 받향과 i가 같은지 확인
                for(int j : tDist) {
                    if(i == (j + 2) % 4) {
                        flag = true;
                        break;
                    }
                }

                f &= flag;

                if(flag && !visited[ny][nx]) {
                    q.offer(new int[]{ny, nx});
                    vCnt++;
                    visited[ny][nx] = true;
                }
            }
        }


        return f ? vCnt : -1;
    }

    //갈수 있는 방향 만들기
    static List<Integer> getDist(char c) {
        List<Integer> d = new ArrayList<>();

        switch(c){
            case '|':
                d.add(0);
                d.add(2);
                break;
            case '-':
                d.add(1);
                d.add(3);
                break;
            case '+':
                d.add(0);
                d.add(1);
                d.add(2);
                d.add(3);
                break;
            case '1':
                d.add(2);
                d.add(3);
                break;
            case '2':
                d.add(0);
                d.add(3);
                break;
            case '3':
                d.add(0);
                d.add(1);
                break;
            case '4':
                d.add(1);
                d.add(2);
                break;
        }

        return d;
    }
}