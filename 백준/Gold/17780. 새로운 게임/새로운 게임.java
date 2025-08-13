import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};

        Block[][] map = new Block[n][n];
        Horse[] horses = new Horse[k];
        int[] height = new int[k];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = new Block(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken()) - 1;

            map[y][x].list.add(i);
            horses[i] = new Horse(y, x, dist);
        }

        int turn = 1;
        boolean flag = false;
        while(turn <= 1000) {
            for(int i = 0; i < k; i++) {
                if(height[i] != 0) continue;

                Horse now = horses[i];

                int ny = now.y + dy[now.dist];
                int nx = now.x + dx[now.dist];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n || map[ny][nx].color == 2) {
                    now.dist = now.dist % 2 == 0 ? now.dist + 1 : now.dist - 1;

                    ny = now.y + dy[now.dist];
                    nx = now.x + dx[now.dist];
                }

                if(ny < 0 || ny >= n || nx < 0 || nx >= n || map[ny][nx].color == 2) continue;

                if(map[ny][nx].color == 0) {
                    int high = map[ny][nx].list.size();
                    List<Integer> list = map[now.y][now.x].list;
                    for(int h : list) {
                        height[h] = high++;
                        horses[h].y = ny;
                        horses[h].x = nx;
                        map[ny][nx].list.add(h);
                    }
                    list.clear();
                } else if(map[ny][nx].color == 1) {
                    int high = map[ny][nx].list.size();
                    Collections.reverse(map[now.y][now.x].list);
                    List<Integer> list = map[now.y][now.x].list;
                    for(int h : list) {
                        height[h] = high++;
                        horses[h].y = ny;
                        horses[h].x = nx;
                        map[ny][nx].list.add(h);
                    }
                    list.clear();
                }

                if(map[ny][nx].list.size() >= 4) {
                    flag = true;
                    break;
                }
            }

            if(flag) break;
            turn++;
        }

        System.out.print(turn > 1000 ? -1 : turn);
    }

    static class Block {
        int color;
        List<Integer> list;

        Block(int color) {
            this.color = color;
            list = new ArrayList<>();
        }
    }

    static class Horse {
        int y, x, dist;

        Horse(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
