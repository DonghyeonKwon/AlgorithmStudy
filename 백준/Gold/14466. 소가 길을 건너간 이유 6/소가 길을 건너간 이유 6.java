import java.io.*;
import java.util.*;

public class Main {
    static int n, k, r;
    static List<Node>[][] list;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());
            int xx = Integer.parseInt(st.nextToken());

            list[y][x].add(new Node(yy, xx));
            list[yy][xx].add(new Node(y, x));
        }

        Node[] cows = new Node[k];
        int[][] map = new int[n+1][n+1];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            cows[i] = new Node(y, x);
            map[y][x] = 1;
        }

        int answer = 0;

        for(int t = 0; t < k; t++) {
            Node cow = cows[t];
            
            boolean[][] visited = new boolean[n+1][n+1];
            boolean[][] cowContacted = new boolean[k][k];

            Queue<Node> q = new ArrayDeque<>();
            visited[cow.y][cow.x] = true;
            q.add(cow);

            while(!q.isEmpty()) {
                Node now = q.poll();

                if(map[now.y][now.x] == 1) {
                    for(int j = t+1; j < k; j++) {
                        if(cows[j].equals(now)) {
                            cowContacted[t][j] = true;
                            break;
                        }
                    }
                }

                for(int i = 0 ; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];

                    if(ny < 1 || ny > n || nx < 1 || nx > n) continue;
                    if(visited[ny][nx]) continue;
                    if(list[now.y][now.x].contains(new Node(ny, nx))) continue;

                    visited[ny][nx] = true;
                    q.add(new Node(ny, nx));
                }
            }

            for(int i = t + 1; i < k; i++) {
                if(!cowContacted[t][i]) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;

            return this.y == node.y && this.x == node.x;
        }
    }
}
