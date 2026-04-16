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
		int y = 0, x = 0;
		for(int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				map[i][j] = input[j];
				if(map[i][j] == '0') {
					y = i;
					x = j;
				}
			}
		}
		
		int res = bfs(y, x);
		
		System.out.println(res);
	}
	
	static int bfs(int y, int x) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(y, x, 0, 0));
		boolean visited[][][] = new boolean[n][m][64];
		visited[y][x][0] = true;
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			y = pos.y;
			x = pos.x;
			int key = pos.k;
			int cnt = pos.cnt;
			
			if(map[y][x] == '1') {
				return cnt;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				int ncnt = cnt + 1;
				int nkey = key;
				
				if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
				if(map[ny][nx] == '#') continue;
				if(visited[ny][nx][key]) continue;
				if('A' <= map[ny][nx] && map[ny][nx] <= 'F' && (key & (1 << (map[ny][nx]-'A'))) == 0) continue;
				if('a' <= map[ny][nx] && map[ny][nx] <= 'f') {
					nkey |= (1 << (map[ny][nx] - 'a'));
					visited[ny][nx][nkey] = true;
					q.offer(new Pos(ny, nx, nkey, ncnt));
				} else if ('A' <= map[ny][nx] && map[ny][nx] <= 'F') {
					if((nkey & (1 << (map[ny][nx]-'A'))) > 0) {
						visited[ny][nx][nkey] = true;
						q.offer(new Pos(ny, nx, nkey, ncnt));
					}
				} else {
					visited[ny][nx][nkey] = true;
					q.offer(new Pos(ny, nx, nkey, ncnt));
				}
				
			}
		}
		
		return -1;
	}
	
	static class Pos{
		int y, x, k, cnt;
		Pos(int y, int x, int k, int cnt){
			this.y = y;
			this.x = x;
			this.k = k;
			this.cnt = cnt;
		}
	}
}