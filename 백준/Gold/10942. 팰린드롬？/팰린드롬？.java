import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] dp = new boolean[n+1][n+1];
		for(int i = 1; i <= n; i++) dp[i][i] = true;
		
		for(int i = 1; i <= n - 1; i++) {
			if(arr[i] == arr[i + 1]) dp[i][i + 1] = true;
		}
		
		for(int i = 2; i < n; i++) {
			for(int j = 1; j <= n - i; j++) {
				if(arr[j] == arr[j + i] &&  dp[j+1][j + i - 1]) {
					dp[j][j + i] = true;
				}
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			bw.write(""+ (dp[y][x]?1:0) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}