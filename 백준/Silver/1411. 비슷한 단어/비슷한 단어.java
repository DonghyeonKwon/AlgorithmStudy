import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int cnt = 0;
        int len = arr[0].length();
        for(int i = 0; i < n; i++) {

            for(int j = i+1; j < n; j++) {
                Map<Character, Character> checkMap = new HashMap<>();
                boolean[] check = new boolean[26];

                boolean flag = true;
                for(int k = 0; k < len; k++) {
                    char a = arr[i].charAt(k);
                    char b = arr[j].charAt(k);

                    if(checkMap.containsKey(a)){
                        if(checkMap.get(a) != b) {
                            flag = false;
                            break;
                        } else {
                            continue;
                        }
                    }

                    if(check[b - 'a']) {
                        flag = false;
                        break;
                    }
                    checkMap.put(a, b);
                    check[b - 'a'] = true;
                }

                if(flag) {
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}
