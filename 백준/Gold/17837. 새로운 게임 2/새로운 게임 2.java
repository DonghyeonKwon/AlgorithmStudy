import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] map;
    static int[] dy = {0, 0, 0, -1, 1};
    static int[] dx = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        Chess[][] board = new Chess[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = new Chess();
            }
        }

        Horse[] arr = new Horse[K+1];
        for(int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[i] = new Horse(y, x, d);

            board[y][x].stk.push(i);
        }

        int cnt = 1;

        game : while(cnt <= 1000) {
            boolean gameFinish = false;

            for(int i = 1; i <= K; i++) {
                if(gameFinish) break game;

                int y = arr[i].y;
                int x = arr[i].x;
                int d = arr[i].d;

                int ny = y + dy[d];
                int nx = x + dx[d];

                List<Integer> list = new ArrayList<>();
                while(!board[y][x].stk.isEmpty() && board[y][x].stk.peek() != i) {
                    list.add(board[y][x].stk.pop());
                }
                list.add(board[y][x].stk.pop());

                if(ny <= 0 || nx <= 0 || ny > N || nx > N || map[ny][nx] == 2){
                    //방향 바꾸기
                    d = changeD(d);
                    arr[i].d = d;

                    ny = y + dy[d];
                    nx = x + dx[d];

                    //바꾼 방향이면 다시 확인
                    if(ny <= 0 || nx <= 0 || ny > N || nx > N || map[ny][nx] == 2) {
                        for(int j = list.size() - 1; j >= 0; j--) {
                            int k = list.get(j);
                            board[y][x].stk.push(k);
                        }

                        if(board[y][x].stk.size() >= 4) gameFinish = true;
                        continue;
                    }
                }

                if(map[ny][nx] == 0) {
                    for(int j = list.size() - 1; j >= 0; j--) {
                        int k = list.get(j);
                        arr[k].y = ny;
                        arr[k].x = nx;
                        board[ny][nx].stk.push(k);
                    }
                } else if(map[ny][nx] == 1) {
                    for(int k : list) {
                        arr[k].y = ny;
                        arr[k].x = nx;
                        board[ny][nx].stk.push(k);
                    }

                }

                if(board[ny][nx].stk.size() >= 4) gameFinish = true;
            }

            if(gameFinish) break;
            //턴 종료
            cnt++;
        }

        System.out.print(cnt > 1000 ? -1 : cnt);
    }

    static int changeD(int d) {
        if(d == 1) return 2;
        if(d == 2) return 1;
        if(d == 3) return 4;
        return 3;
    }

    static class Horse {
         int y, x, d;
         Horse(int y, int x, int d) {
             this.y = y;
             this.x = x;
             this.d = d;
         }
    }

    static class Chess {
        Stack<Integer> stk = new Stack<>();
    }
}
