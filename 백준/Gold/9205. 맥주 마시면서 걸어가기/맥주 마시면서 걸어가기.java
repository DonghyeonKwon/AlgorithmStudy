import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] pos, map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		while(t --> 0) {
			n = Integer.parseInt(br.readLine());
			pos = new int[n+2][2];
			map = new int[n+2][n+2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			pos[0][0] = Integer.parseInt(st.nextToken());
			pos[0][1] = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			pos[n+1][0] = Integer.parseInt(st.nextToken());
			pos[n+1][1] = Integer.parseInt(st.nextToken());
			
			
			
			for(int i = 0; i < n+2; i++) {
				for(int j = i+1; j < n+2; j++) {
					int dis = Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
					map[i][j] = dis;
					map[j][i] = dis;
				}
			}
			
			bfs(0);
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(int here) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean visited[][] = new boolean[n+2][n+2];
		q.offer(here);
		boolean flag = false;
		
		while(!q.isEmpty()) {
			here = q.poll();
			
			if(here == n+1) {
				flag = true;
				break;
			}
			
			for(int i = 1; i < n+2; i++) {
				if(here == i) continue;
				if(visited[here][i]) continue;
				if(map[here][i] > 1000) continue;
				visited[here][i] = true;
				visited[i][here] = true;
				q.offer(i);
			}
		}
		
		if(flag) sb.append("happy\n");
		else sb.append("sad\n");
	}
	
	static class Pos{
		int y, x;
		Pos() {}
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}