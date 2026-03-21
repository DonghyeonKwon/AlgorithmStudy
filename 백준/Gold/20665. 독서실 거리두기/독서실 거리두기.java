import java.io.*;
import java.util.*;

public class Main {
    static int n, t, p, ans = 0;
    static Info[] arr;
    static boolean[][] seat;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        arr = new Info[t];
        seat = new boolean[n+1][1261];
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            start = (start / 100) * 60 + (start % 100);
            end = (end / 100) * 60 + (end % 100);
            arr[i] = new Info(start, end);
        }
        Arrays.sort(arr);


        for(int i = 0; i < t; i++) {
            int idx = getFavoriteSeat(i);
            fillArray(idx, i);
        }

        for(int i = 540; i < 1260; i++) {
            if(!seat[p][i]) ans++;
        }

        System.out.print(ans);
    }

    static void fillArray(int k, int idx) {
        for(int i = arr[idx].start; i < arr[idx].end; i++) {
            seat[k][i] = true;
        }
    }

    static int getFavoriteSeat(int i) {
        int maxDist = 0;
        int pos = 0;
        for(int idx = 1; idx <= n; idx++) {
            if(!seat[idx][arr[i].start]) {
                int dist = getDistance(arr[i].start, idx);
                if(maxDist < dist) {
                    maxDist = dist;
                    pos = idx;
                }
            }
        }

        return pos;
    }

    static int getDistance(int min, int idx) {
        int minDist = 1000;
        for(int i = 1; i <= n; i++) {
            if(i == idx) continue;
            if(seat[i][min]) {
                int dist = Math.abs(i - idx);
                if(minDist > dist) {
                    minDist = dist;
                }
            }
        }

        return minDist;
    }

    static class Info implements Comparable<Info> {
        int start, end;

        Info(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Info o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
