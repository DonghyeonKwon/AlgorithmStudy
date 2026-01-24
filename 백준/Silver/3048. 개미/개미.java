import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        Ant[] line = new Ant[n1 + n2];
        for(int i = 0; i < n1; i++) {
            line[n1 - 1 - i] = new Ant(0, arr1[i]);
        }
        for(int i = n1; i < n1 + n2; i++) {
            line[i] = new Ant(1, arr2[i-n1]);
        }

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            Queue<int[]> q = new ArrayDeque<>();

            for(int i = 1; i < n1 + n2; i++) {
                if(!line[i-1].flag && line[i].flag){
                    q.add(new int[]{i-1, i});
                }
            }

            while(!q.isEmpty()) {
                int[] pos = q.poll();

                Ant tmp = null;
                tmp = line[pos[0]];
                line[pos[0]] = line[pos[1]];
                line[pos[1]] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n1 + n2; i++) {
            sb.append(line[i].c);
        }

        System.out.print(sb);

    }

    static class Ant{
        boolean flag;
        char c;

        Ant(int i, char c) {
            this.flag = 1 == i;
            this.c = c;
        }
    }
}
