import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] arr = new int[p];
        int[] rank = new int[p];

        int r = 1, temp = 1;
        if(n > 0)st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 0) {
                rank[i] = r;
                temp++;
            } else {
                if(arr[i] == arr[i-1]) {
                    rank[i] = r;
                    temp++;
                } else {
                    r = temp;
                    rank[i] = r;
                    temp++;
                }
            }

        }
        int res = -1;
        int i = 0;
        for(i = n-1; i >= 0; i--) {
            if(score < arr[i]) {
                int rr = rank[i] + go(rank, rank[i], i);
                if(i+1 < p) {
                    res = rr;
                }
                break;
            } else if(score == arr[i]) {
                int rr = rank[i];
                if(i+1 < p) {
                    res = rr;
                }
                break;
            }
        }

        if(i == -1) {
            res = 1;
        }

        System.out.print(res);
    }

    static int go(int[] rank, int r, int start) {
        int cnt = 0;
        while(start >= 0 && rank[start] == r) {
            cnt++;
            start--;
        }
        return cnt;
    }
}
