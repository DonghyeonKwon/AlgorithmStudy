import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int dp[] = new int[10000001];
		
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= t; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		
		System.out.println(dp[t]);
	}
}