import java.io.*;
import java.util.*;

public class Main {
	static int r, c;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static boolean[][] visited = new boolean[250][250];
	static char[][] map = new char[250][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int res[] = new int[2];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(!visited[i][j] && map[i][j] != '#') {
					int[] ret = bfs(i, j);
					if(ret[0] > ret[1]) {
						res[0] += ret[0];
					} else {
						res[1] += ret[1];
					}
				}
			}
		}
		
		System.out.println(res[0] + " " + res[1]);
	}
	
	static int[] bfs(int y, int x) {
		int[] ret = new int[2];
		Queue<int[]> q = new ArrayDeque<>();
		visited[y][x] = true;
		if(map[y][x] == 'v') ret[1]++;
		if(map[y][x] == 'o') ret[0]++;
		q.offer(new int[] {y,x});
		
		while(!q.isEmpty()) {
			int pos[] = q.poll();
			y = pos[0];
			x = pos[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if(visited[ny][nx]) continue;
				if(map[ny][nx] == '#') continue;
				
				if(map[ny][nx] == 'v') ret[1]++;
				if(map[ny][nx] == 'o') ret[0]++;
				
				visited[ny][nx] = true;
				q.offer(new int[] {ny, nx});
			}
		}
		
		return ret;
	}
}