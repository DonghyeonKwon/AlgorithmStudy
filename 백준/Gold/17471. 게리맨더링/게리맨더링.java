import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, min = Integer.MAX_VALUE;
	static int[] ingu;
	static boolean[][] map;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		ingu = new int[n+1];
		selected = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			ingu[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new boolean[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			for(int j = 0; j < t; j++) {
				map[i][Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		combination(1, 0);
		
		if(min == Integer.MAX_VALUE) min = -1;
		
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs (boolean[] v, int now ) {
		if(v[now]) return;
		
		v[now] = true;
		
		for(int i = 1; i <= n; i++) {
			if(selected[i] != selected[now]) continue;
			if(v[i]) continue;
			if(!map[now][i]) continue;
			dfs(v, i);
		}
	}
	
	static void combination(int idx, int cnt) {
		if(idx == n+1 && (cnt == 0 || cnt == n)) return;
		
		if(idx == n+1) {
			//dfs 확인하고
			//가능하면 계산
			//불가능하면 컷
			boolean[] v = new boolean[n+1];
			int nCnt = 0;
			for(int i = 1; i <= n; i++) {
				if(!v[i]) {
					dfs(v, i);
					nCnt++;
				}
			}
			
			if(nCnt != 2) return;
			
			int aSum = 0, bSum = 0;
			
			for(int  i = 1; i <= n; i++) {
				if(selected[i]) aSum += ingu[i];
				else bSum += ingu[i];
			} 
//			for(int i = 1; i <= n; i++) {
//				System.out.print(selected[i] + " ");
//			}
//			System.out.println();
//			System.out.println(nCnt + " " + Math.abs(aSum - bSum));
			
			min = Math.min(min, Math.abs(aSum - bSum));
			return;
		}
		
		combination(idx+1, cnt);
		selected[idx] = true;
		combination(idx+1, cnt+1);
		selected[idx] = false;
	}
}
