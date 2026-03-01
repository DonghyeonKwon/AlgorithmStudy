import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] arr, answer;
    static Group[][] groups = new Group[2][2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                groups[i][j] = new Group(
                        (i == 0) ? 0 : n / 2,
                        (i == 0) ? n / 2 : n,
                        (j == 0) ? 0 : m / 2,
                        (j == 0) ? m / 2 : m
                );
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < r; i++) {
            int a = Integer.parseInt(st.nextToken());
            apply(a);
        }

        int h = groups[0][0].rot % 2 == 0 ? n : m;
        int w = groups[0][0].rot % 2 == 0 ? m : n;

        answer = new int[h][w];

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                draw(groups[i][j], i, j, h, w);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                sb.append(answer[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void apply(int cmd) {
        if(cmd == 1) {
            for(int i = 0; i < 2; i++) {
                Group tmp = groups[0][i];
                groups[0][i] = groups[1][i];
                groups[1][i] = tmp;

                groups[0][i].flipByY();
                groups[1][i].flipByY();
            }
        } else if(cmd == 2) {
            for(int i = 0; i < 2; i++) {
                Group tmp = groups[i][0];
                groups[i][0] = groups[i][1];
                groups[i][1] = tmp;

                groups[i][0].flipByX();
                groups[i][1].flipByX();
            }
        } else if(cmd == 3) {
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    groups[i][j].rotate(1);
                }
            }

            Group tmp = groups[0][0];
            groups[0][0] = groups[1][0];
            groups[1][0] = groups[1][1];
            groups[1][1] = groups[0][1];
            groups[0][1] = tmp;

        } else if(cmd == 4) {
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    groups[i][j].rotate(3);
                }
            }

            Group tmp = groups[0][0];
            groups[0][0] = groups[0][1];
            groups[0][1] = groups[1][1];
            groups[1][1] = groups[1][0];
            groups[1][0] = tmp;

        } else if(cmd == 5) {
            Group tmp = groups[0][0];
            groups[0][0] = groups[1][0];
            groups[1][0] = groups[1][1];
            groups[1][1] = groups[0][1];
            groups[0][1] = tmp;

        } else if(cmd == 6) {
            Group tmp = groups[0][0];
            groups[0][0] = groups[0][1];
            groups[0][1] = groups[1][1];
            groups[1][1] = groups[1][0];
            groups[1][0] = tmp;
        }
    }

    static void draw(Group g, int i, int j, int h, int w) {
        int gh = g.ey - g.sy;
        int gw = g.ex - g.sx;

        int oh = (g.rot % 2 == 0) ? gh : gw;
        int ow = (g.rot % 2 == 0) ? gw : gh;

        int cellH = h / 2;
        int cellW = w / 2;

        int baseY = i * cellH;
        int baseX = j * cellW;

        for (int yy = 0; yy < gh; yy++) {
            for (int xx = 0; xx < gw; xx++) {

                int srcY = g.sy + yy;
                int srcX = g.sx + xx;

                int fy = g.flipY ? (gh - 1 - yy) : yy;
                int fx = g.flipX ? (gw - 1 - xx) : xx;

                int ry = 0, rx = 0;
                int r = g.rot % 4;

                if (r == 0) {
                    ry = fy;  rx = fx;
                } else if (r == 1) {
                    ry = fx;
                    rx = (gh - 1 - fy);
                } else if (r == 2) {
                    ry = (gh - 1 - fy);
                    rx = (gw - 1 - fx);
                } else {
                    ry = (gw - 1 - fx);
                    rx = fy;
                }

                answer[baseY + ry][baseX + rx] = arr[srcY][srcX];
            }
        }
    }

    static class Group {
        int sy, ey, sx, ex;
        boolean flipY = false;
        boolean flipX = false;
        int rot = 0;

        Group(int sy, int ey, int sx, int ex) {
            this.sy = sy;
            this.ey = ey;
            this.sx = sx;
            this.ex = ex;
        }

        void flipByY() {
            if(rot % 2 == 0) flipY = !flipY;
            else flipX = !flipX;
        }

        void flipByX() {
            if(rot % 2 == 0) flipX = !flipX;
            else flipY = !flipY;
        }

        void swapFlip() {
            boolean tmp = flipX;
            flipX = flipY;
            flipY = tmp;
        }

        void rotate(int c) {
            rot = (rot + c) % 4;
        }

    }
}
