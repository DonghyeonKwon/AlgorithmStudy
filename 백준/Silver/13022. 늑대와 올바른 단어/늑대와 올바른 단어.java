import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        boolean flag = true;
        int w = 0;

        for(int i = 0; flag && i < arr.length; i++) {
            if(arr[i] == 'w') {
                w++;
            } else {
                if(w == 0) {
                    flag = false;
                    break;
                }
                
                if(i + w * 3 - 1 >= arr.length) {
                    flag = false;
                    break;
                }
                
                int j = 0;
                for(int k = 1; flag && k <= 3; k++) {
                    for(j = i + w * (k - 1); j < i + w * k; j++) {
                        if((k == 1 && arr[j] != 'o') || (k == 2 && arr[j] != 'l') || (k == 3 && arr[j] != 'f')) {
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag) {
                    i += w * 3 - 1;
                    w = 0;
                }
            }
        }

        if(w != 0) flag = false;

        System.out.print(flag ? 1 : 0);
    }
}
