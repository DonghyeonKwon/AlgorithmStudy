import java.util.*;

public class Main {
    static int n, c = 0, m;
    static boolean[] visited;
    static int[] choose;
    static List<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[10001];
        choose = new int[m];
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            if(visited[a]) continue;
            arr.add(a);
            visited[a] = true;
            c++;
        }

        Collections.sort(arr);
        go(0);

        System.out.println(sb);
    }

    static void go(int cnt){
        if(cnt == m){
            for(int i = 0; i < m; i++){
                sb.append(choose[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 0; i < c; i++) {
            choose[cnt] = arr.get(i);
            go(cnt + 1);
        }
    }
}
