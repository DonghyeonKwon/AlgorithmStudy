import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int n, max, res;
	static int[] cal, score;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			res = 0;
			
			cal = new int[n];
			score = new int[n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			go(0, 0, 0);
			
			sb.append(res).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void go(int idx, int ksum, int ssum) {
		if(max < ksum) return;
		
		if(idx == n) {
			if(res < ssum) res = ssum;
			return;
		}
		
		go(idx+1, ksum, ssum);
		go(idx+1, ksum + cal[idx], ssum + score[idx]);
	}
}
