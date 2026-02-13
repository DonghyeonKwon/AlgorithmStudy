import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Info[] arr = new Info[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Info(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr,
                (o, p) -> {
                    if(o.k == p.k) return o.p - p.p ;
                    return o.k - p.k;
                }
        );

        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(m == 0) break;
            if(arr[i].p == 0) continue;

            if(arr[i].k == 0) {
                if(arr[i].p - 1 <= m) {
                    m -= (arr[i].p - 1);
                    sum += arr[i].p;
                } else {
                    sum += m;
                    m = 0;
                }

                continue;
            }

            if(arr[i].p <= m) {
                m -= arr[i].p;
                sum += arr[i].p;
            } else {
                sum += m;
                m = 0;
            }
        }

        System.out.print(sum);
    }

    static class Info {
        int p, k;

        Info(int num) {
            this.p = num / 10;
            this.k = num % 10;
        }
    }
}
