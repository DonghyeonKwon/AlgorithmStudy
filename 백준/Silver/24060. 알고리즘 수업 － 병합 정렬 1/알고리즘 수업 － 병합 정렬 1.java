import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr, tmp;
    static int num = -1;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        tmp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n-1, arr);

        System.out.print(num);
    }

    static void mergeSort(int l, int r, int[] arr) {
        if(cnt > k) return;
        if(l < r) {
            int m = (l + r) / 2;
            mergeSort(l, m, arr);
            mergeSort(m+1, r, arr);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        
        while(i <= q && j <= r) {
            if(arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        while(i <= q) {
            tmp[t++] = arr[i++];
        }

        while(j <= r) {
            tmp[t++] = arr[j++];
        }

        i = p;
        t = 0;
        while(i <= r) {
            cnt++;
            if(cnt == k) {
                num = tmp[t];
                break;
            }
            arr[i++] = tmp[t++];
        }
    }
}
