import java.io.*;
import java.util.*;

public class Main {
    static final int LEFT = 0;
    static final int UP = 1;
    static final int RIGHT = 2;
    static final int DOWN = 3;

    static final int ROTATE_LEFT = -1;
    static final int ROTATE_RIGHT = 1;

    static final int[] dy = {0, -1, 0, 1};
    static final int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());

        int size = 2 * L + 1;

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(-1, size, size, size));
        lines.add(new Line(size, -1, size, size));
        lines.add(new Line(-1, -1, -1, size));
        lines.add(new Line(-1, -1, size, -1));

        int time = 0;
        int rotateDir;
        int y = L;
        int x = L;
        int curDir = RIGHT;
        long collisionTime = 0L;

        for(int i = 0; i <= r; i++) {
            if(i < r) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                time = Integer.parseInt(st.nextToken());
                rotateDir = st.nextToken().charAt(0) == 'L' ? ROTATE_LEFT : ROTATE_RIGHT;
            } else {
                time = 1_000_000_000;
                rotateDir = -1;
            }

            int t = 1_000_000_000;

            for(int l = 0; l < lines.size(); l++) {
                Line prevLine = lines.get(l);

                switch(curDir) {
                    case LEFT:
                        if((prevLine.dir == 0 && prevLine.y1 == y && x > prevLine.x2) ||
                           (prevLine.dir == 1 && y >= prevLine.y1 && y <= prevLine.y2 &&
                                    x > prevLine.x2)
                        ) {
                            t = Math.min(t, x - prevLine.x2);
                        }
                        break;
                    case RIGHT:
                        if((prevLine.dir == 0 && prevLine.y1 == y && x < prevLine.x1) ||
                           (prevLine.dir == 1 && prevLine.y1 <= y && y <= prevLine.y2 &&
                                    x < prevLine.x1)) {
                            t = Math.min(t, prevLine.x1 - x);
                        }
                        break;
                    case DOWN:
                        if ((prevLine.dir == 0 && x >= prevLine.x1 && x <= prevLine.x2 &&
                                y < prevLine.y1) ||
                                (prevLine.dir == 1 && x == prevLine.x1 && y < prevLine.y1)
                        ) {
                            t = Math.min(t, prevLine.y1 - y);
                        }
                        break;
                    case UP:
                        if ((prevLine.dir == 0 && x >= prevLine.x1 && x <= prevLine.x2 &&
                                y > prevLine.y1) ||
                                (prevLine.dir == 1 && prevLine.x1 == x && y > prevLine.y2)
                        ) {
                            t = Math.min(t, y - prevLine.y2);
                        }
                        break;
                }
            }

            if(t <= time) {
                collisionTime += t;
                break;
            }

            collisionTime += time;

            int ny = y + dy[curDir] * time;
            int nx = x + dx[curDir] * time;

            lines.add(new Line(y, x, ny, nx));

            y = ny;
            x = nx;
            curDir = (curDir + rotateDir + 4) % 4;
        }

        System.out.print(collisionTime);
    }

    static class Line {
        int y1, x1, y2, x2;
        int dir;

        Line(int y1, int x1, int y2, int x2) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = y2;
            this.x2 = x2;

            setDirection();
            setPoint();
        }

        private void setDirection() {
            if(this.y1 == this.y2) {
                this.dir = 0;
            } else {
                this.dir = 1;
            }
        }

        private void setPoint() {
            if(y1 > y2) {
                y1 ^= y2;
                y2 ^= y1;
                y1 ^= y2;
            }

            if(x1 > x2) {
                x1 ^= x2;
                x2 ^= x1;
                x1 ^= x2;
            }
        }
    }

}
