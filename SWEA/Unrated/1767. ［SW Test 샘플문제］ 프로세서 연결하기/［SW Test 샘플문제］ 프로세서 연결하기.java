import java.util.*;
import java.io.*;

public class Solution {
	static int n, coreMax, core, min, sp;
	static int[][] map;
	static Pos[] corePos;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			coreMax = core = sp = 0;
			min = Integer.MAX_VALUE;
			corePos = new Pos[12];
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(i == 0 || i == n-1 || j == 0 || j == n -1) {
							sp++;
							continue;
						}
						corePos[core++] = new Pos(i, j);
					}
				}
			}
			//System.out.println("core : " + core + " sp : " + sp);
			dfs(0, 0, 0);
			
			sb.append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int idx, int cnt, int sum) {
		if(idx == core) {
			
//			for(int i  = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			if(idx == core) {
			if(coreMax > cnt+sp) return;
			
			if(coreMax < cnt + sp) {
				coreMax = cnt + sp;
				min = sum;
			}else if(coreMax == cnt + sp) {
				if(min > sum) min = sum;
			}
			
			return;
		}
			
			return;
		}
		
		//연결 했을 때,
		for(int i = 0; i < 4; i++) {
			boolean flag = true;
			List<Pos> tmp = new ArrayList<>();
			int y = corePos[idx].y;
			int x = corePos[idx].x;
			
			while(true) {
				y += dy[i];
				x += dx[i];
				
				if(map[y][x] != 0) {
					flag = false;
					break;
				}
				
				tmp.add(new Pos(y,x));
				
				if(x == 0 || x == n-1 || y == 0 || y == n-1) {
					break;
				}
			}
			
			if(flag) {
				for(Pos p : tmp) map[p.y][p.x] = 2;
				dfs(idx+1, cnt+1, sum + tmp.size());
				for(Pos p : tmp) map[p.y][p.x] = 0;
			}
		}
        //corePos[idx]을 연결하지 않았을 때,
		dfs(idx+1, cnt, sum);
	}
	
	static class Pos{
		int y, x;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}