import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Country[] arr = new Country[n];
        Country target = null;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i] = new Country(num, a, b, c);

            if(num == k) {
                target = arr[i];
            }
        }

        Arrays.sort(arr);

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(target.a == arr[i].a && target.b == arr[i].b && target.c == arr[i].c) {
                System.out.print(count + 1);
                break;
            } else {
                count++;
            }
        }
    }

    static class Country implements Comparable<Country> {
        int num, a, b, c;

        Country(int num, int a, int b, int c) {
            this.num = num;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Country o) {
            if(this.a == o.a) {
                if(this.b == o.b) {
                    return o.c - this.c;
                }

                return o.b - this.b;
            }

            return o.a - this.a;
        }
    }
}
