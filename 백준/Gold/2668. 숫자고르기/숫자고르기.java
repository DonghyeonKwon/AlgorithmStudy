import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[101];
    static boolean[] visited = new boolean[101];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(int i : list) {
            sb.append(i).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int now, int target) {
        if(!visited[arr[now]]) {
            visited[arr[now]] = true;
            dfs(arr[now], target);
            visited[arr[now]] = false;
        }
        if(arr[now] == target) list.add(target);
    }
}
