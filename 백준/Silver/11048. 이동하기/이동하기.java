import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n+1][m+1];
		int[][] dp = new int[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dp[1][1] = map[1][1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				int[] arr = new int[3];
				arr[0] = dp[i-1][j] + map[i][j];// y+1, x
				arr[1] = dp[i][j-1] + map[i][j];// y, x+1
				arr[2] = dp[i-1][j-1] + map[i][j];// y+1, x+1
				
				for(int a : arr) {
					dp[i][j] = Math.max(a, dp[i][j]);
				}
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
