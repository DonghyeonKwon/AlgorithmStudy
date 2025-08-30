import java.io.*;
import java.util.*;

public class Main {
    static int n, count = 0;
    static int[] arr;
    static boolean[] visited;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i= 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while(true) {
                if(i == left) left++;
                else if(i == right) right--;

                if(left >= right) break;

                if(arr[left] + arr[right] > arr[i]) right--;
                else if(arr[left] + arr[right] < arr[i]) left++;
                else {
                    count++;
                    break;
                }
            }
        }

        System.out.print(count);
    }
}
