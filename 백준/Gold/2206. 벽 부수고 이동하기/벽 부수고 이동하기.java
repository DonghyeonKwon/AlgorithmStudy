import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static char map[][];
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int res = bfs(0, 0);
		System.out.println(res);
	}
	
	static int bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x, 0, 0});
		boolean visited[][][] = new boolean[2][n][m];
        visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			y = p[0];
			x = p[1];
			int cnt = p[2];
			int broken = p[3];
			
			if(y == n-1 && x == m-1) return cnt + 1;
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
				
				//원래 맵이 1이면
				if(map[ny][nx] == '1') {
					//벽을 부순 적이 없다면
					if(broken == 0) {
						visited[broken+1][ny][nx] = true; 
						q.offer(new int[]{ny, nx, cnt+1, broken+1});
					}
				}else if(map[ny][nx] == '0') {
					if(broken == 1 && !visited[broken][ny][nx]) {
						visited[broken][ny][nx] = true; 
						q.offer(new int[] {ny, nx, cnt+1, broken});
					} else if(broken == 0 && !visited[broken][ny][nx]) {
						visited[broken][ny][nx] = true; 
						q.offer(new int[] {ny, nx, cnt+1, broken});
					}
				}
			}
		}

		return -1;
	}
}