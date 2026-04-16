import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int h = arr[n-1];
        int cnt = 1;
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] > h){
                h = arr[i];
                cnt++;
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();

        bw.close();
        br.close();
    }
}
