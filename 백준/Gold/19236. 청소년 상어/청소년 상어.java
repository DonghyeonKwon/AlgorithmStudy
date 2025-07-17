import java.util.*;
import java.io.*;

public class Main {
    static int max = -1;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[4][4];
        Fish[] arr = new Fish[17];
        Fish shark;

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                 int num = Integer.parseInt(st.nextToken());
                 int d = Integer.parseInt(st.nextToken());

                 map[i][j] = num;
                 arr[num] = new Fish(i, j, d-1, false);
            }
        }

        //상어 자리 (0, 0);
        int f = map[0][0];
        arr[f].dead = true;
        shark = new Fish(0, 0, arr[f].d, true);;
        map[0][0] = -1;

        go(map, shark, arr, f);

        System.out.print(max);
    }

    static void go(int[][] map, Fish shark, Fish[] arr, int sum) {
        if(max < sum) {
            max = sum;
        }

        moveFish(map, arr);

        for(int i = 1; i < 4; i++) {
            int ny = shark.y + dy[shark.d] * i;
            int nx = shark.x + dx[shark.d] * i;

            if(0 <= ny && ny < 4 && 0 <= nx && nx < 4 && map[ny][nx] > 0) {
                int[][] mapCopy = copyMap(map);
                Fish[] arrCopy = copyArr(arr);

                int num = mapCopy[ny][nx];
                Fish f = arrCopy[num];
                f.dead = true;

                mapCopy[shark.y][shark.x] = 0;
                mapCopy[f.y][f.x] = -1;
                Fish nextShark = new Fish(f.y, f.x, f.d, true);

                go(mapCopy, nextShark, arrCopy, sum + num);
            }
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        return newMap;
    }

    static Fish[] copyArr(Fish[] arr) {
        Fish[] newArr = new Fish[17];

        for(int i = 1; i <= 16; i++) {
            Fish f = arr[i];
            newArr[i] = new Fish(f.y, f.x, f.d, f.dead);
        }

        return newArr;
    }

    static void moveFish(int[][] map, Fish[] arr){

        for(int i = 1; i <= 16; i++) {
            if(arr[i].dead) continue;

            Fish f = arr[i];
            for(int j = 0; j < 8; j++) {
                int nextDir = (f.d + j) % 8;
                int ny = f.y + dy[nextDir];
                int nx = f.x + dx[nextDir];

                if(0 <= ny && ny < 4 && 0 <= nx && nx < 4 && map[ny][nx] > -1) {
                    map[f.y][f.x] = 0;

                    if(map[ny][nx] == 0) {
                        f.y = ny;
                        f.x = nx;
                    } else {
                        Fish temp = arr[map[ny][nx]];
                        temp.y = f.y;
                        temp.x = f.x;
                        map[f.y][f.x] = map[ny][nx];

                        f.y = ny;
                        f.x = nx;
                    }

                    map[ny][nx] = i;
                    f.d = nextDir;
                    break;
                }
            }
        }
    }

    static class Fish{
        int y, x, d;
        boolean dead;

        Fish(int y, int x, int d, boolean dead) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.dead = dead;
        }
    }
}
