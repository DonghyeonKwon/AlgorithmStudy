import java.util.*;

public class Main {
    static int n, m, arr[], choose[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        choose = new int[m];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        go(0);

        System.out.println(sb);
    }

    static void go(int cnt) {
        if(cnt == m){
            for(int i = 0; i < m; i++){
                sb.append(choose[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(cnt > 0 && choose[cnt-1] > arr[i]) continue;
            choose[cnt] = arr[i];
            go(cnt+1);
        }
    }
}
