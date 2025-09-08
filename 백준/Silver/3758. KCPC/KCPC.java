import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] arr = new Team[n];
            for(int i = 1; i <= n; i++) {
                arr[i-1] = new Team(i);
                arr[i-1].score = new int[k+1];
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int id = Integer.parseInt(st.nextToken()) - 1;
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                if(arr[id].score[j] < s) {
                    arr[id].sum -= arr[id].score[j];
                    arr[id].sum += s;
                    arr[id].score[j] = s;
                }

                arr[id].cnt++;
                arr[id].lastIdx = i;
            }

            Arrays.sort(arr);

            for(int i = 0; i < n; i++) {
                if(arr[i].num == t) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }

    static class Team implements Comparable<Team>{
        int num;
        int[] score;
        int sum;
        int cnt;
        int lastIdx;

        Team(int num) {
            this.num = num;
            this.cnt = 0;
            this.sum = 0;
        }

        @Override
        public int compareTo(Team o){
            if(o.sum == this.sum) {
                if(this.cnt == o.cnt) {
                    return this.lastIdx - o.lastIdx;
                }
                return this.cnt - o.cnt;
            }
            return o.sum - this.sum;
        }
    }
}
