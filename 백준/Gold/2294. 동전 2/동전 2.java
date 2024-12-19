import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), k = sc.nextInt();
	
		int[] dp = new int[k+1];
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		
		for(int i = 0; i < n; i++) {
			int coin = sc.nextInt();
			
			if(coin > k) continue;
			
			for(int j = coin; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin]+1);
			}
		}
		
		if(dp[k] == 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
		
	}
}
