import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k, x;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
		}
		
		int[] res = bfs();
		
		int count = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= n; i++) {
			if(res[i] == k) {
				count++;
				sb.append(i).append('\n');
			}
		}
		
		if(count == 0) {
			System.out.println(-1);
		} else {
			System.out.print(sb.toString());
		}
	}
	
	static int[] bfs() {
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		boolean[] visited = new boolean[n+1];
		visited[x] = true;
		distance[x] = 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, 0});
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int here = pos[0];
			int dis = pos[1];
			
			if(distance[here] < dis) continue;
			
			for(int next : list[here]) {
				if(distance[next] > dis + 1) {
					distance[next] = dis+1;
					q.offer(new int[] {next, distance[next]});
				}
			}
		}
		
		return distance;
	}
}