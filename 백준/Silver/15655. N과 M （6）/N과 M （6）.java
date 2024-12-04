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
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        combi(0, 0);

        System.out.println(sb);
    }

    static void combi(int idx, int cnt){
        if(cnt == m){
            for(int i = 0; i < m; i++){
                sb.append(choose[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i < n; i++){
            choose[cnt] = arr[i];
            combi(i+1, cnt+1);
        }
    }
}
