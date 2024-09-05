import java.io.*;
import java.util.*;

public class Main {
	static int n, m, map[][];
	static boolean[][] v;
	static List<List<int[]>> list = new ArrayList<>();
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//섬찾고 섬 좌표 저장하기
		list.add(new ArrayList<>());
		int idx = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!v[i][j] && map[i][j] == 1) {
					list.add(new ArrayList<>());
					bfs(i, j , idx);
					idx++;
				}
			}
		}
		
		int[][] matrix = new int[idx][idx];
		
		//각 좌표 값으로 각 섬까지 가는지 확인하기
		for(int i = 1; i < idx; i++) {
			for(int[] pos : list.get(i)) {
				int y = pos[0];
				int x = pos[1];
				
				for(int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					int cnt = 0;
					
					while(0 <= ny && ny < n && 0 <= nx && nx < m) {
						if(map[ny][nx] == 0) {
							cnt++;
							ny += dy[d];
							nx += dx[d];
							continue;
						}
						
						if(map[ny][nx] == i) {
							break;
						}
						
						if(map[ny][nx] != i) {
							if(cnt <= 1) break;
							if(matrix[i][map[ny][nx]] == 0) {
								matrix[i][map[ny][nx]] = cnt;
							} else {
								if(matrix[i][map[ny][nx]] > cnt) {
									matrix[i][map[ny][nx]] = cnt;
								}
							}
							break;
						}
					}
				}
			}
		}
		
		//mst 시작
		int cnt = 0, cost = 0, mv = -1;
		boolean[] visited = new boolean[idx];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		int[] weight = new int[idx];
		Arrays.fill(weight, Integer.MAX_VALUE);
		
		weight[1] = 0;
		pq.add(new int[] {1,0});
		
		
		while(!pq.isEmpty()) {
			int[] pos = pq.poll();
			mv = pos[0];
			int w = pos[1];
			if(visited[mv]) continue;
			
			cost += w;
			visited[mv] = true;
			cnt++;
			if(cnt == idx - 1) break;
			
			for(int next = 1; next < idx; next++) {
				if(visited[next]) continue;
				if(matrix[mv][next] == 0) continue;
				if(weight[next] <= matrix[mv][next]) continue;
				weight[next] = matrix[mv][next];
				pq.add(new int[] {next, weight[next]});
			}
		}
		
		if(cnt == idx - 1) {
			System.out.println(cost);
		} else {
			System.out.println(-1);
		}
		
	}
	
	static void bfs(int y, int x, int idx) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x});
		v[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			y = p[0];
			x = p[1];
			
			map[y][x] = idx;
			list.get(idx).add(p);
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
				if(v[ny][nx]) continue;
				if(map[ny][nx] != 1) continue;
				v[ny][nx] = true;
				q.offer(new int[] {ny, nx});
			}
		}
	}
}