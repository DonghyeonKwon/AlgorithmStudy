import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] arr;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[n][i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        while(!isFinish()) {
            time++;
            pushFish();

            make2D();
            adjustFish();

            make1D();
            fold();
            adjustFish();

            make1D();
        }

        System.out.print(time);
    }

    static boolean isFinish() {
        int max = 0;
        int min = 99999999;
        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= n; x++) {
                if(arr[y][x] == 0) continue;
                if(max < arr[y][x]) max = arr[y][x];
                if(min > arr[y][x]) min = arr[y][x];
            }
        }

        if(max - min <= k) {
            return true;
        } else {
            return false;
        }
    }

    static void pushFish() {
        List<Integer> list = new ArrayList<>();
        int min = 999999999;
        for(int i = 1; i <= n; i++) {
            if(arr[n][i] < min) {
                list.clear();
                list.add(i);
                min = arr[n][i];
            } else if(arr[n][i] == min) {
                list.add(i);
            }
        }

        for(int i : list) {
            arr[n][i]++;
        }
    }

    static void make2D() {
        int pivotX = 1;
        int w = 1;
        int h = 1;
        int idx = 0;
        while(pivotX - 1 + w + h <= n) {
            idx++;
            for(int x = pivotX; x < pivotX + w; x++) {
                for(int y = n; y > n - h; y--){
                    int ny = n - w + x - pivotX;
                    int nx = pivotX + w + n - y;
                    arr[ny][nx] = arr[y][x];
                    arr[y][x] = 0;
                }
            }

            pivotX += w;
            if(idx % 2 == 0) {
                w++;
            } else {
                h++;
            }
        }
    }

    static void adjustFish() {
        int[][] tempArr = new int[n+1][n+1];

        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= n; x++) {
                if(arr[y][x] == 0) continue;
                for(int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if((ny < 1 || nx < 1 || ny > n || nx > n) || arr[ny][nx] == 0) continue;
                    int diff = arr[y][x] - arr[ny][nx];
                    diff /= 5;
                    if(diff > 0) {
                        tempArr[y][x] -= diff;
                        tempArr[ny][nx] += diff;
                    }
                }
            }
        }

        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= n; x++) {
                arr[y][x] += tempArr[y][x];
            }
        }
    }

    static void make1D() {
        List<Integer> list = new ArrayList<>();

        for(int x = 1; x <= n; x++) {
            for(int y = n; y >= 1; y--) {
                if(arr[y][x] == 0) break;
                list.add(arr[y][x]);
                arr[y][x] = 0;
            }
        }

        for(int i = 0; i < n; i++) {
            arr[n][i+1] = list.get(i);
        }
    }

    static void fold() {
        List<Integer> list = new ArrayList<>();
        int pivotX = 1;
        int yCnt = 1;
        for(int cnt = 1; cnt <= 2; cnt++) {
            int _y = n - yCnt * 2 + 1;
            for(int y = n; y > n - yCnt; y--) {
                list.clear();

                for(int x = pivotX; x < pivotX + (n - pivotX + 1) / 2; x++) {
                    list.add(arr[y][x]);
                    arr[y][x] = 0;
                }

                for(int idx = 0; idx < list.size(); idx++) {
                    arr[_y][n - idx] = list.get(idx);
                }
                _y++;
            }
            yCnt *= 2;
            pivotX += n/2;
        }
    }
}
