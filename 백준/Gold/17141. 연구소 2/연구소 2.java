import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, v; // n : map size, v : virus quantity 
	static int[][] map, visited;
	static pair[] vpos; //virus position
	static int res = 987654321;
	static int[] combi;
	static int zeroCnt = 0, vposLen = 0;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		vpos = new pair[10];
		combi = new int[v];
		
		int idx = 0; // virus index;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
				if(map[i][j] != 1) zeroCnt++;
				if(map[i][j] == 2) {
					vpos[idx] = new pair(i, j);
					map[i][j] = 0;
					idx++;
				}
			}
		}
		vposLen = idx;
		
		//virus combination
		combiVirus(0, 0);
		
		System.out.println(res == 987654321 ? -1 : res);
	}
	
	static void combiVirus(int s, int cnt) { //Combination by recursive function
		if(cnt == v) {
			bfs();
			return;
		}
		
		for(int i = s; i < vposLen; i++) {
			combi[cnt] = i;
			combiVirus(i+1, cnt+1);
			combi[cnt] = -1;
		}
	}
	
	static void bfs() {
		visited = new int[n][n];
		Queue<pair> queue = new LinkedList<>();
		
		int cnt = 0, ret = 0;
		for(int i = 0; i < v; i++) {
			queue.add(vpos[combi[i]]);
			visited[vpos[combi[i]].first][vpos[combi[i]].second] = 1;
			cnt++;
		}
		
		while(!queue.isEmpty()) {
			int y = queue.peek().first;
			int x = queue.peek().second;
			ret = Math.max(ret, visited[y][x]);
			queue.poll();
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
				if(map[ny][nx] == 1) continue;
				if(visited[ny][nx] > 0) continue;
				visited[ny][nx] = visited[y][x] + 1;
				cnt++;
				queue.add(new pair(ny, nx));
			}
		}
		
		if(zeroCnt == cnt) {
			res = Math.min(res, ret - 1);
		}

//		if(zeroCnt == cnt) return;
//		int ret = 0;
//		//bfs 한 후, visited[][]배열에 최댓값 - 1 이 바이러스가 다 퍼진 시간 
//		//그 시간을 찾으면서 map[]의 모든 0이 방문 했는지 확
//		for(int i = 0; i < n; i++) { 
//			for(int j = 0; j < n; j++) {
//				if(map[i][j] == 1) continue; // if map[i][j] is wall, continue
//				// if map[i][j] is 0 and visited[i][j] is 0, it is not all over the virus. so return
//				if(map[i][j] == 0 && visited[i][j] == 0) return;
//				ret = Math.max(ret, visited[i][j] - 1);
//			}
//		}
		
//		무사히 나오면 res 와 ret 를 비교해서 최소 시간 구하
//		res = Math.min(res, ret);
	}

}

class pair{
	int first;
	int second;
	
	public pair(int first, int second){
		this.first = first;
		this.second = second;
	}
}
