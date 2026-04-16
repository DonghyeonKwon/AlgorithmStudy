import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()) + 1;
		list = new List[n];
		for(int i = 1; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		int cnt = bfs(x, y, n);
		
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int bfs(int x, int y, int n) {
		Queue<Integer> q = new ArrayDeque<>();
		int v[] = new int[n];
		q.offer(x);
		v[x] = 1;
		
		while(!q.isEmpty()) {
			x = q.poll();
			
			if(x == y) break;
			for(int next : list[x]) {
				if(v[next] > 0) continue;
				v[next] = v[x] + 1;
				q.offer(next);
			}
		}
		
		return (v[y] - 1);
	}
}
