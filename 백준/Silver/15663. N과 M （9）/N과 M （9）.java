import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, choose;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        choose = new int[m];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        go(0);

        System.out.println(sb);
    }
    private static void go(int cnt) {
        if(cnt == m) {
            for(int i = 0; i < m; i++) {
                sb.append(choose[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;

            if(before != arr[i]){
                visited[i] = true;
                choose[cnt] = arr[i];
                go(cnt + 1);
                before = arr[i];
                visited[i] = false;
            }
        }
    }
}
