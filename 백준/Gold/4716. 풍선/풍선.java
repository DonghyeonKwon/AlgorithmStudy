import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(n == 0) break;

            Team[] arr = new Team[n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                int dA = Integer.parseInt(st.nextToken());
                int dB = Integer.parseInt(st.nextToken());

                arr[i] = new Team(k, dA, dB);
            }

            Arrays.sort(arr);

            int sum = 0;
            for(int i = 0; i < n; i++) {
                Team t = arr[i];
                if(t.dA < t.dB) {
                    if(A - t.k < 0) {
                        sum += A * t.dA;
                        t.k -= A;
                        A = 0;
                        sum += t.k * t.dB;
                        B -= t.k;
                    } else {
                        A -= t.k;
                        sum += t.k * t.dA;
                    }
                } else {
                    if(B - t.k < 0) {
                        sum += B * t.dB;
                        t.k -= B;
                        B = 0;
                        sum += t.k * t.dA;
                        A -= t.k;
                    } else {
                        B -= t.k;
                        sum += t.k * t.dB;
                    }
                }
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }

    static class Team implements Comparable<Team> {
        int k, dA, dB;

        Team(int k, int dA, int dB) {
            this.k = k;
            this.dA = dA;
            this.dB = dB;
        }

        @Override
        public int compareTo(Team o) {
            return Math.abs(o.dA - o.dB) - Math.abs(this.dA - this.dB);
        }

    }
}
