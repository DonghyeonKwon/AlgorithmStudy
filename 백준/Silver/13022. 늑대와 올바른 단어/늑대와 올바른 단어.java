import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[] arr;
    static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        n = arr.length;

        if(arr[0] != 'w') {
            System.out.print(0);
            return;
        }

        boolean flag = true;

        map.put('w', 'o');
        map.put('o', 'l');
        map.put('l', 'f');
        map.put('f', '0');

        int cnt = 0;
        for(int i = 0; i < n && flag; i++) {
            if(arr[i] == 'w') {
                cnt++;
            } else {
                if(cnt == 0) {
                    flag = false;
                    break;
                }
                flag = check(i, cnt, 'o');
                if(flag) {
                    i += cnt * 3;
                    i -= 1;
                    cnt = 0;
                }
            }
        }

        if(cnt != 0) flag = false;

        System.out.print(flag ? 1 : 0);
    }

    static boolean check(int idx, int cnt, char c) {
        if(c == '0') return true;

        int tempCnt = 0;
        for(int i = idx; i < n; i++) {
            if(arr[i] == c) {
                tempCnt++;
            } else {
                if(tempCnt == cnt) {
                    return check(i, tempCnt, map.get(c));
                } else {
                    return false;
                }
            }
        }

        if(tempCnt == cnt) {
            return c == 'f';
        }

        return false;
    }
}
