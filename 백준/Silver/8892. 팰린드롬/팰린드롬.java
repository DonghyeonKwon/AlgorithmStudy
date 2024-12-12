import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];

            for(int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            boolean flag = true;

            loop : for(int i = 0; i < n-1; i++){
                for(int j = i+1; j < n; j++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(arr[i]).append(arr[j]);

                    if(palindrome(sb.toString().toCharArray())){
                        flag = false;
                        System.out.println(sb);
                        break loop;
                    }

                    sb = new StringBuilder();
                    sb.append(arr[j]).append(arr[i]);

                    if(palindrome(sb.toString().toCharArray())){
                        flag = false;
                        System.out.println(sb);
                        break loop;
                    }
                }
            }

            if(flag) System.out.println(0);
        }
    }

    static boolean palindrome(char[] str) {
        for(int i = 0; i < str.length/2; i++){
            if(str[i] != str[str.length-1-i]) return false;
        }

        return true;
    }
}
