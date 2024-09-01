import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, zeroCnt = 0, min = Integer.MAX_VALUE;
	static int[][] map, visited;
	static List<Data> list = new ArrayList<>();
	static List<Data> list5 = new ArrayList<>(); // 4빙향
	static int[] dy = { -1, 0, 1, 0, -1, 0 };
	static int[] dx = { 0, -1, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 6)
					continue;

				if (map[i][j] == 0) {
					zeroCnt++;
					continue;
				}
				if (map[i][j] == 5) {
					list5.add(new Data(i, j, map[i][j]));
					visited[i][j] = 1;
					continue;
				}

				list.add(new Data(i, j, map[i][j]));
				visited[i][j] = 1;
			}
		}
		for (int i = 0; i < list5.size(); i++) {
			Data d = list5.get(i);
			dfs_4(d.y, d.x);
		}
		k = list.size();
		dfs(0, 0);
		
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int idx, int sum) {
		if (idx == k) {
			if (min > zeroCnt - sum) {
				min = zeroCnt - sum;
			}
			return;
		}
		
		int[][] tmp = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				tmp[i][j] = visited[i][j];
			}
		}
		
		Data data = list.get(idx);
		for (int d = 0; d < 4; d++) {
			int cnt = 0;
			switch (data.kind) {
			case 1:
				cnt += watching(data.y, data.x, d);
				break;
			case 2:
				cnt += watching(data.y, data.x, d);
				cnt += watching(data.y, data.x, d + 2);
				break;
			case 3:
				cnt += watching(data.y, data.x, d);
				cnt += watching(data.y, data.x, d+1);
				break;
			case 4:
				cnt += watching(data.y, data.x, d);
				cnt += watching(data.y, data.x, d+1);
				cnt += watching(data.y, data.x, d+2);
				break;
			}
			
			dfs(idx+1, sum + cnt);
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					visited[i][j] = tmp[i][j];
				}
			}
		}
	}

	static int watching(int y, int x, int d) {
		int sum = 0;
		y += dy[d];
		x += dx[d];
		while(!(y < 0 || y >= n || 0 > x || x >= m)) {
			if(map[y][x] == 6) break;
			if(visited[y][x] > 0) {
				y += dy[d];
				x += dx[d];
				continue;
			}
			visited[y][x] = 1;
			y += dy[d];
			x += dx[d];
			sum++;
		}
		return sum;
	}

	static void dfs_4(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];
			while (!(0 > ny || ny >= n || 0 > nx || nx >= m)) {
				if (map[ny][nx] == 6)
					break;
                if(visited[ny][nx] > 0) {
					ny += dy[d];
					nx += dx[d];
					continue;
				}
				if (map[ny][nx] == 0) {
					visited[ny][nx] = 1;
					zeroCnt--;
				}
				ny += dy[d];
				nx += dx[d];
			}
		}
	}

	static class Pos {
		int y, x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class Data extends Pos {
		int kind;

		Data(int y, int x, int kind) {
			super(y, x);
			this.kind = kind;
		}
	}
}