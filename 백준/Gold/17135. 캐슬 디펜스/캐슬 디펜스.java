import java.io.*;
import java.util.*;

/*
 * 궁수 3명을 m개의 자리 중 3자리를 선택(조합).
 */

public class Main {
	static int n, m, d, max = 0;
	static int[][] map;
	static int[][] visited;
	static int[] dy = {0, -1, 0};
	static int[] dx = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < m - 2; i++) {
			for(int j = i+1; j < m - 1; j++) {
				for(int k = j+1; k < m; k++) {
					visited = new int[n][m];
					go(i, j, k);
				}
			}
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void go(int i, int j, int k) {
		int cnt = 0;
		for(int r = n -1; r >= 0; r--) {
			//if(!check(r)) break;
			
			Pos[] p = new Pos[3];
			p[0] = bfs(r, i);
			p[1] = bfs(r, j);
			p[2] = bfs(r, k);
			
			for(int idx = 0; idx < 3; idx++) {
				if(p[idx].d == 0) continue;
				if(visited[p[idx].y][p[idx].x] == 0) {
					cnt++;
					visited[p[idx].y][p[idx].x] = 1; 
				}
			}
		}
		if(max < cnt) max = cnt;
	}
	
	static Pos bfs(int r, int c) {
		List<Pos> list = new ArrayList<>();
		Queue<Pos> q = new ArrayDeque<>();
		int[][] v = new int[r+1][m];
		q.offer(new Pos(1, r, c));
		v[r][c] = 1;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(visited[p.y][p.x] == 0 && map[p.y][p.x] == 1) {
				list.add(p);
			}
			
			if(p.d + 1 > d) continue;
			
			for(int i = 0; i < 3; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				int nd = p.d + 1;
				if(ny < 0 || nx < 0 || nx >= m) continue;
				if(v[ny][nx] > 0) continue;
				if(visited[ny][nx] > 0) continue;
                v[ny][nx] = 1;
				q.offer(new Pos(nd, ny, nx));
			}
		}
		
		if(list.size() > 0) {
			Collections.sort(list);
			return list.get(0);
		}
		
		return new Pos(0, 0, 0);
	}
	
	static boolean check(int r) {
		for(int i = 0; i <= r; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) return true;
			}
		}
		
		return false;
	}
	
	static class Pos implements Comparable<Pos>{
		int d, y, x;
		Pos(int d, int y, int x){
			this.d = d;
			this.y = y;
			this.x = x;
		}
		
		@Override
		public int compareTo(Pos o) {
			if(this.d == o.d) {
				return this.x - o.x;
			}
			return this.d - o.d;
		}
	}
}