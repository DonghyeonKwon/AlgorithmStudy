import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map;

    static int[] dy = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Pos I = new Pos(-1, -1);
        List<Pos> Rs = new ArrayList<>();
        map = new char[r][c];

        for(int i = 0; i < r; i++) {
            String input = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);

                if(map[i][j] == 'I') {
                    I.y = i;
                    I.x = j;
                } else if(map[i][j] == 'R') {
                    Rs.add(new Pos(i, j));
                }
            }
        }
        boolean[] alive = new boolean[Rs.size()];
        Arrays.fill(alive, true);

        char[] methods = br.readLine().toCharArray();
        int len = methods.length;

        int i = 0;
        boolean flag = true;
        for(; i < len; i++) {
            //1. 이동
            int d = (methods[i] - '0') - 1;

            int ny = I.y + dy[d];
            int nx = I.x + dx[d];

            //2.
            if(map[ny][nx] == 'R') {
                flag = false;
                break;
            }

            map[I.y][I.x] = '.';
            map[ny][nx] = 'I';
            I.y = ny;
            I.x = nx;

            //3.
            int[][] check = new int[r][c];
            for(int j = 0; j < Rs.size(); j++) {
                if(!alive[j]) continue;

                Pos R = Rs.get(j);
                int nextY = 0, nextX = 0;
                int dist = 10000000;
                for(int p = 0; p < 9; p++) {
                    if(p == 4) continue;
                    int newY = R.y + dy[p];
                    int newX = R.x + dx[p];

                    if(newY < 0 || newY >= r || newX < 0 || newX >= c) continue;
                    if(dist > Math.abs(I.y - newY) + Math.abs(I.x - newX)) {
                        dist = Math.abs(I.y - newY) + Math.abs(I.x - newX);
                        nextY = newY;
                        nextX = newX;
                    }
                }

                check[nextY][nextX]++;
                map[R.y][R.x] = '.';
                R.y = nextY;
                R.x = nextX;
            }

            //4.
            if(check[I.y][I.x] > 0) {
                flag = false;
                break;
            }

            //5.
            for(int y = 0; y < r; y++) {
                for(int x = 0; x < c; x++) {
                    if(check[y][x] > 1) {
                        for(int j = 0; j < Rs.size(); j++) {
                            if(!alive[j]) continue;
                            if(Rs.get(j).y == y && Rs.get(j).x == x) {
                                alive[j] = false;
                            }
                        }
                    } else if(check[y][x] == 1) {
                        map[y][x] = 'R';
                    }
                }
            }
        }

        if(!flag) {
            System.out.print("kraj " + (i+1));
        } else {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < r; j++) {
                sb.append(map[j]);
                if(j < r - 1) sb.append('\n');
            }
            System.out.print(sb);
        }
    }

    static class Pos {
        int y, x;
        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
