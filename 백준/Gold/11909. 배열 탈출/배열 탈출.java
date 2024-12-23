import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	
	static int[] dy = {1, 0};
	static int[] dx = {0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] visited = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			Arrays.fill(visited[i], 999999999);
		}
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(1, 1, 0));
		visited[1][1] = 0;
		
		while(!pq.isEmpty()) {
			Pos p = pq.poll();
			int y = p.y;
			int x = p.x;
			int won = p.won;
			
			for(int i = 0; i < 2; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				int nwon = won;
				
				if(ny < 1 || nx < 1 || ny > n || nx > n) continue;
				
				if(map[ny][nx] >= map[y][x]) {
					nwon += (map[ny][nx] - map[y][x] + 1);
				}
				
				if(nwon >= visited[ny][nx]) continue;
				
				visited[ny][nx] = nwon;
				pq.offer(new Pos(ny, nx, nwon));
			}
		}
		
		System.out.println(visited[n][n]);
	}
	
	static class Pos implements Comparable<Pos>{
		int y, x, won;
		Pos(int y, int x, int won){
			this.y = y;
			this.x = x;
			this.won = won;
		}
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.won, o.won);
		}
	}
}
