import java.io.*;
import java.util.*;

public class Main {
	static int n, m, zeroCnt = 0, max = 0;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static List<Pos> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//입력
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					list.add(new Pos(i, j));
					continue;
				}
				if(map[i][j] == 0) {
					zeroCnt++;
					continue;
				}
			}
		}
		//벽 3개를 세우면 사라지는 수
		zeroCnt -= 3;
		
		//벽을 3개를 조합으로 세우고 
		//bfs 바이러스가 퍼지는 수 만큼 zeroCnt에 뺀 수를 max에 갱신
		combi(0);
		//결과
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		for(Pos p : list) {
			visited[p.y][p.x]= true; 
			q.offer(p);
		}
		//바이러스는 map에서 0으로만 사라지기 때문에 사라지는 0 counting
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
				if(visited[ny][nx]) continue;
				if(map[ny][nx] != 0) continue;
				visited[ny][nx] = true;
				q.offer(new Pos(ny, nx));
				cnt++;
			}
		}
		//max값 보다 남아있는 0의 개수가 많으면 갱신
		if(max < zeroCnt - cnt) max = zeroCnt - cnt;
	}
	//조합
	static void combi(int cnt) {
		if(cnt == 3) {
			bfs();//bfs 시작
			return;
		}
		//해당 위치에 0 -> 1 해주고 백트래킹 1 -> 0 해주기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] != 0) continue;
				map[i][j] = 1;
				combi(cnt+1);
				map[i][j] = 0;
			}
		}
	}
	
	static class Pos{
		int y, x;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
