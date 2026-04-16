import java.io.*;
import java.util.*;

public class Main {
    static int max = -1, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(map, 0);

        bw.write(Integer.toString(max));
        bw.flush();

        bw.close();
        br.close();
    }

    static void go(int[][] map, int cnt) {
        if(cnt == 10) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    max = Math.max(max, map[i][j]);
                }
            }
            return;
        }

        int[][] temp = new int[n][n];
        initTemp(temp, map);

        //좌
        left(temp);
        go(temp, cnt+1);
        initTemp(temp, map);

        //우
        right(temp);
        go(temp, cnt+1);
        initTemp(temp, map);

        //위
        up(temp);
        go(temp, cnt+1);
        initTemp(temp, map);

        //아래
        down(temp);
        go(temp, cnt+1);
    }

    static boolean left(int[][] temp) {
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            int num = 0, k = 0;
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                if(temp[i][j] == 0) continue;

                if(num == 0) {
                    num = temp[i][j];
                    continue;
                }

                if(num == temp[i][j]) {
                    arr[k] = num * 2;
                    k++;
                    temp[i][j] = 0;
                    num = 0;
                    flag = true;
                } else if (num != temp[i][j]) {
                    arr[k] = num;
                    k++;
                    num = temp[i][j];
                }
            }
            arr[k] = num;
            temp[i] = arr;
        }

        return flag;
    }

    static boolean right(int[][] temp) {
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            int num = 0, k = n-1;
            int[] arr = new int[n];
            for(int j = n-1; j >= 0; j--) {
                if(temp[i][j] == 0) continue;

                if(num == 0) {
                    num = temp[i][j];
                    continue;
                }

                if(num == temp[i][j]) {
                    arr[k] = num * 2;
                    k--;
                    temp[i][j] = 0;
                    num = 0;
                    flag = true;
                } else if (num != temp[i][j]) {
                    arr[k] = num;
                    k--;
                    num = temp[i][j];
                }
            }
            arr[k] = num;
            temp[i] = arr;
        }

        return flag;
    }

    static boolean up(int[][] temp) {
        boolean flag = false;
        for(int j = 0; j < n; j++) {
            int num = 0, k = 0;
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                if(temp[i][j] == 0) continue;

                if(num == 0) {
                    num = temp[i][j];
                    continue;
                }

                if(num == temp[i][j]) {
                    arr[k] = num * 2;
                    k++;
                    temp[i][j] = 0;
                    num = 0;
                    flag = true;
                } else if (num != temp[i][j]) {
                    arr[k] = num;
                    k++;
                    num = temp[i][j];
                }
            }
            arr[k] = num;

            for(int i = 0; i < n; i++) {
                temp[i][j] = arr[i];
            }
        }

        return flag;
    }

    static boolean down(int[][] temp) {
        boolean flag = false;
        for(int j = 0; j < n; j++) {
            int num = 0, k = n-1;
            int[] arr = new int[n];
            for(int i = n-1; i >= 0; i--) {
                if(temp[i][j] == 0) continue;

                if(num == 0) {
                    num = temp[i][j];
                    continue;
                }

                if(num == temp[i][j]) {
                    arr[k] = num * 2;
                    k--;
                    temp[i][j] = 0;
                    num = 0;
                    flag = true;
                } else if (num != temp[i][j]) {
                    arr[k] = num;
                    k--;
                    num = temp[i][j];
                }
            }
            arr[k] = num;

            for(int i = 0; i < n; i++) {
                temp[i][j] = arr[i];
            }
        }

        return flag;
    }

    static void initTemp(int[][] temp, int[][] map) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp[i][j] = map[i][j];
            }
        }
    }
}
