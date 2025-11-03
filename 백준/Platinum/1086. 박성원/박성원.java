import java.io.*;
import java.util.*;

public class Main {

    static String[] nums;
    static int n, k;
    static int maxBitmask;
    static long[][] dp;
    static int[][] mods;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new String[n];
        for(int i = 0; i < n; i++) {
            nums[i] = br.readLine();
        }

        k = Integer.parseInt(br.readLine());
        maxBitmask = (1 << n) - 1;
        dp = new long[1 << n][k];
        mods = new int[n][k];

        for(int j = 0; j < k; j++) {
            for(int i = 0; i < n; i++) {
                mods[i][j] = -1;
            }
            for(int i = 0; i <= maxBitmask; i++) {
                dp[i][j] = -1;
            }
        }

        long answer = calc(0, 0);

        if(answer == 0) {
            System.out.println("0/1");
        } else {
            long fac = 1;
            for(int i = 2; i <= n; i++) {
                fac *= i;
            }
            long gcd = getGcd(fac, answer);
            System.out.println(answer/gcd+"/"+fac/gcd);
        }
    }

    static long getGcd(long n, long m) {
        if(m == 0) return n;
        return getGcd(m, n%m);
    }

    static long calc(int bitmask, int mod) {
        if(dp[bitmask][mod] !=  -1) {
            return  dp[bitmask][mod];
        }

        if(bitmask == maxBitmask) {
            return mod == 0 ? 1 : 0;
        }

        long count = 0;
        for(int i = 0; i < n; i++) {
            int idx = 1 << i;
            if((bitmask & idx) == 0) {
                count += calc(bitmask|idx, getMod(i, mod));
            }
        }

        return dp[bitmask][mod] = count;
    }

    static int getMod(int idx, int mod) {
        if(mods[idx][mod] != -1) return mods[idx][mod];
        int curr = mod;
        int length = nums[idx].length();

        for(int i = 0; i < length; i++) {
            curr *= 10;
            curr += (nums[idx].charAt(i)-'0');
            curr %= k;
        }

        return mods[idx][mod] = curr;
    }

}
