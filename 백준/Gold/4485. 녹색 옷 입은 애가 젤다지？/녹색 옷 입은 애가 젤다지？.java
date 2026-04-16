import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static final int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int idx = 1;
		while((n = Integer.parseInt(br.readLine())) != 0){
			map = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int res = minCount();
			
			sb.append("Problem ").append(idx).append(":").append(" ").append(res).append("\n");
			idx++;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int minCount() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[n][n];
		int[][] minCost = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				minCost[i][j] = INF;
			}
		}
		minCost[0][0] = map[0][0];
		
		pq.offer(new Pos(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Pos p = pq.poll();
			int y = p.y;
			int x = p.x;
			int c = p.c;
			
			if(visited[y][x]) continue;
			
			visited[y][x] = true;
			if(y == n - 1 && x == n-1) break;
			
			for(int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
				if(visited[ny][nx]) continue;
				if(minCost[ny][nx] <= c + map[ny][nx]) continue;
				minCost[ny][nx] = c + map[ny][nx];
				pq.offer(new Pos(ny, nx, minCost[ny][nx]));
			}
		}
		return minCost[n-1][n-1];
	}
	
	static class Pos implements Comparable<Pos>{
		int y,x,c;
		Pos(int y, int x, int c){
			this.y = y;
			this.x = x;
			this.c = c;
		}
		@Override
		public int compareTo(Pos o) {
			return this.c - o.c;
		}
	}
}