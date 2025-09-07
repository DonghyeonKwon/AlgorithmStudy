import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            int len = map.size();
            int[] tScore = new int[len+1];
            int[][] order = new int[len+1][2];
            int score = 1;
            for(int i = 0; i < n; i++) {
                if(map.get(arr[i]) < 6) continue;
                order[arr[i]][0]++;
                if(order[arr[i]][0] >= 6) {
                    score++;
                    continue;
                }
                if(order[arr[i]][0] == 5) {
                    order[arr[i]][1] = score;
                } else {
                    tScore[arr[i]] += score;
                }
                score++;
            }

            int idx = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= len; i++) {
                if(tScore[i] == 0) continue;
                if(min > tScore[i]){
                    min = tScore[i];
                    idx = i;
                } else if(min == tScore[i]) {
                    if(order[i][1] < order[idx][1]) {
                        idx = i;
                    }
                }
            }

            sb.append(idx).append('\n');
        }

        System.out.print(sb);
    }
}
