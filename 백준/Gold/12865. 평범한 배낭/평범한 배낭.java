import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n+1][k+1];
		Pair[] pair = new Pair[n+1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			pair[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int j = 1; j <= k; j++) {
			for(int i = 1; i <= n; i++) {
				if(j < pair[i].w) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-pair[i].w] + pair[i].v);
			}
		}
		System.out.println(dp[n][k]);
	}
	
	static class Pair{
		int w, v;
		Pair(int w, int v){
			this.w = w;
			this.v = v;
		}
	}
}