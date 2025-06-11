import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        boolean flag = false;
        int sum = 0;

        for(int i = 0; i <= 12; i++){
            if(arr[i] == '*'){
                if(i % 2 == 1) flag = true;
                continue;
            }

            if(i % 2 == 0) sum += (arr[i] - '0');
            else sum += ((arr[i] - '0') * 3);
        }

        int ans = 10 - sum % 10;
        
        if(ans == 10) {
            System.out.println(0);
            return;
        }
        
        if(flag) {
            while(ans % 3 != 0){
                ans += 10;
            }
            ans /= 3;
        }

        System.out.println(ans);
    }
}
