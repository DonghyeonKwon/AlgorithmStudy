import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] visited = new boolean[1001];
        Arrays.fill(visited, true);

        for(int i = 123; i <= 987; i++){
            char[] arr = String.valueOf(i).toCharArray();
            if(arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0]) visited[i] = false;
            if(arr[0] == '0' || arr[1] == '0' || arr[2] == '0') visited[i] = false;
        }

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] num = st.nextToken().toCharArray();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int i = 123; i <= 987; i++){
                int s_cnt = 0;
                int b_cnt = 0;

                if(visited[i]) {
                    char[] arr = String.valueOf(i).toCharArray();

                    for(int j = 0; j < 3; j++){
                        for(int k =  0; k < 3; k++){
                            if(j == k && num[j] == arr[k]) s_cnt++;
                            if(j != k && num[j] == arr[k]) b_cnt++;
                        }
                    }

                    if(s_cnt != s || b_cnt != b) visited[i] = false;
                }
            }
        }

        int cnt = 0;
        for(int i = 123; i <= 987; i++){
            if(visited[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
