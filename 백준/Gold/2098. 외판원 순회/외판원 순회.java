import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, map[][], dp[][];
	static int INF = 16000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][(1 << n)];
		for(int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(dfs(0, 1));
	}
	
	static int dfs(int idx, int visited) {
		if(dp[idx][visited] != -1) {
			return dp[idx][visited];
		}
		
		if(visited == ((1 << n) - 1)){
			return dp[idx][visited] = map[idx][0] != 0 ? map[idx][0] : INF;
		}
		
		dp[idx][visited] = INF;
		for(int i = 0; i < n; i++) {
			if(map[idx][i] == 0) continue;
			if((visited & (1 << i)) != 0) continue;
			
			dp[idx][visited] = Math.min(dp[idx][visited], dfs(i, visited | 1 << i) + map[idx][i]);
		}
		
		return dp[idx][visited];
	}
}
