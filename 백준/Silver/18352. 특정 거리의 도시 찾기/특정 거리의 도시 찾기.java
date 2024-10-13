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
		
		boolean[] visited = new boolean[n+1];
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		int cnt = 0;
		int start = -1;
		int dis = -1;
		distance[x] = 0;
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(x, 0));
		
		while(!pq.isEmpty()) {
			Pos pos = pq.poll();
			start = pos.e;
			dis = pos.dis;
			
			if(visited[start]) continue;
			
			visited[start] = true;
			cnt++;
			
			if(cnt == n) break;
			
			for(int next : list[start]) {
				if(visited[next]) continue;
				if(distance[next] > dis + 1) {
					distance[next] = dis + 1;
					pq.add(new Pos(next, distance[next]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= n; i++) {
			if(distance[i] == k) {
				sb.append(i).append('\n');
			}
		}
		
		String res = sb.toString();
		if(res.length() == 0) {
			System.out.println(-1);
		} else {
			System.out.print(res);
		}
		
	}
	
	static class Pos implements Comparable<Pos>{
		int e;
		int dis;
		Pos(int e, int dis){
			this.e = e;
			this.dis = dis;
		}
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.dis, o.dis);
		}
	}
}
