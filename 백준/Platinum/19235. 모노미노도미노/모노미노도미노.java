import java.io.*;
import java.util.*;

public class Main {
    static int score = 0;
    static int[][] green = new int[6][4];
    static int[][] blue = new int[6][4];
    static int[][] temp = new int[6][4];
    static int[][] input = new int[2][4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            inputGreen(t, x);
            inputBlue(t, y);
        }

        int sum = 0;
        for(int i = 2; i < 6; i++) {
            for(int j = 0; j < 4; j++) {
                if(green[i][j] > 0) sum += 1;
                if(blue[i][j] > 0) sum += 1;
            }
        }

        System.out.print(score + "\n" + sum);
    }

    static void inputGreen(int t, int x) {
        //내리기
        if(t == 1) {
            green[1][x] = 1;
        } else if(t == 2) {
            green[1][x] = green[1][x + 1] = 2;
        } else if(t == 3) {
            green[0][x] = green[1][x] = 1;
        }
        
        fallBlock(green);

        while(checkScore(green)) {
            fallBlock(green);
        }

        check01(green);
    }

    static void inputBlue(int t, int x) {
        int xx = 3 - x;
        if(t == 3) xx -= 1;
        if(t == 1) {
            blue[1][xx] = 1;
        } else if(t == 2) {
            blue[0][xx] = blue[1][xx] = 1;
        } else if(t == 3) {
            blue[1][xx] = blue[1][xx+1] = 2;
        }
        fallBlock(blue);

        while(checkScore(blue)) {
            fallBlock(blue);
        }

        check01(blue);
    }

    static boolean checkScore(int[][] arr) {
        boolean flag = false;
        for(int i = 2; i < 6; i++) {
            int cnt = 0;
            for(int j = 0; j < 4; j++) {
                if(arr[i][j] > 0) cnt++;
            }

            if(cnt == 4) {
                for(int j = 0; j < 4; j++) {
                    arr[i][j] = 0;
                }
                score++;
                flag = true;
            }
        }
        return flag;
    }

    static void fallBlock(int[][] arr) {
        for(int i = 5; i >= 0; i--) {
            for(int j = 0; j < 4; j++) {
                int y = i;
                if(arr[i][j] == 1) {
                    for(; y < 6; y++) {
                       if(temp[y][j] > 0){
                            break;
                        }
                    }
                    temp[y-1][j] = 1;
                    arr[i][j] = 0;
                } else if(arr[i][j] == 2) {
                    for(; y < 6; y++) {
                        if (temp[y][j] > 0 || temp[y][j + 1] > 0) {
                            break;
                        }
                    }
                    temp[y-1][j] = 2;
                    temp[y-1][j + 1] = 2;
                    arr[i][j] = 0;
                    arr[i][j+1] = 0;
                    j++;
                }
            }
        }

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 4; j++) {
                arr[i][j] = temp[i][j];
                temp[i][j] = 0;
            }
        }
    }

    static void check01(int[][] arr) {
        int y = 0;
        loop : for(; y < 2; y++) {
            for(int j = 0; j < 4; j++) {
                if(arr[y][j] > 0) break loop;
            }
        }

        if(y == 2) return;
        if(y == 0) y = 2;

        for(int i = 5; i >= 2; i--) {
            for(int j = 0; j < 4; j++) {
                arr[i][j] = arr[i-y][j];
                arr[i-y][j] = 0;
            }
        }

    }

}
