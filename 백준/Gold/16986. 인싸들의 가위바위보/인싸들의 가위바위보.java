import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static boolean[] visited;
    static int[][] arr;
    static int[] idx = {0, 1, 1};
    static int[] winCnt = new int[3];
    static int[][] grr = new int[3][21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 20; i++) {
            grr[1][i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 20; i++) {
            grr[2][i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(dfs(0, 1, 1, 0) ? 1 : 0);

    }

    static boolean dfs(int i, int j, int round, int hand) {
        if(round >= 20) return false;
        if(hand == n && winCnt[0] < k) return false;
        if(winCnt[0] == k) {
            return true;
        }
        if(winCnt[1] == k || winCnt[2] == k) {
            return false;
        }


        boolean flag = false;
        if(i == 0) {
            for(int h = 1; !flag && h <= n; h++) {
                if(visited[h]) continue;
                visited[h] = true;
                if(arr[h][grr[j][idx[j]]] == 2) {
                    winCnt[i]++;
                    idx[j]++;
                    flag |= dfs(i, j == 1 ? 2 : 1, round+1, hand + 1);
                    winCnt[i]--;
                    idx[j]--;
                } else {
                    winCnt[j]++;
                    idx[j]++;
                    flag |= dfs(1, 2, round+1, hand + 1);
                    winCnt[j]--;
                    idx[j]--;
                }
                visited[h] = false;
            }
        } else {
            if(arr[grr[i][idx[i]]][grr[j][idx[j]]] == 2) {
                winCnt[i]++;
                idx[i]++;
                idx[j]++;
                flag |= dfs(0, i, round+1, hand);
                winCnt[i]--;
                idx[i]--;
                idx[j]--;
            } else {
                winCnt[j]++;
                idx[i]++;
                idx[j]++;
                flag |= dfs(0, j, round+1, hand);
                winCnt[j]--;
                idx[i]--;
                idx[j]--;
            }
        }

        return flag;
    }
}
