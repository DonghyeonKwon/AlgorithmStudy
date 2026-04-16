import java.util.*;

public class Main {
    static int n, m, arr[], choose[];
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        visited = new boolean[n];
        choose = new int[m];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        combi(0);

        System.out.println(sb);
    }

    static void combi(int cnt){
        if(cnt == m){
            for(int i = 0; i < m; i++){
                sb.append(choose[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            choose[cnt] = arr[i];
            combi(cnt+1);
            visited[i] = false;
        }
    }
}
