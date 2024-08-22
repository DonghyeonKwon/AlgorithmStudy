import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			int[] min = new int[1];
			int[] col = new int[n+1];
			
			if(n == 0) { sb.append(1).append("\n"); continue; }
			if(n == 2 || n == 3) { sb.append(0).append("\n"); continue; }
			
			go(col, 1, n, min);
			sb.append(min[0]).append("\n");
		}
		bw.write(sb.toString().toCharArray());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void go(int[] col, int cnt, int n, int[] min) {
		if(!isAvailable(col, cnt - 1)) return;
			
		if(cnt > n) {
			min[0]++;
			return;
		}
			
		for(int i = 1; i <= n; i++) {
			if(i == col[cnt-1]) continue;
			col[cnt] = i;
			go(col, cnt + 1, n, min);
		}
	}
	
	static boolean isAvailable(int[] col, int a) {
		for(int i = 1; i < a; i++) {
			if(col[a] == col[i] || a - i == Math.abs(col[a] - col[i])) return false;
		}
		return true;
	}
}
