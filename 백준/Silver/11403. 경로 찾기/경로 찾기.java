import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			boolean[] res = dikstra(i);
			for(int j = 0; j < n; j++) {
				if(res[j]) {
					sb.append(1).append(' ');
				} else {
					sb.append(0).append(' ');
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean[] dikstra(int here) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		boolean[] visited = new boolean[n];
		int[] minCost = new int[n];
		int cnt = 0;
		Arrays.fill(minCost, Integer.MAX_VALUE);
		
		pq.offer(new Edge(here, 0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			here = e.end;
			int dis = e.cost;
			
			if(minCost[here] < dis) continue;
			
			for(int next = 0; next < n; next++) {
				if(map[here][next] == 0) continue;
				if(minCost[next] > dis + 1) {
					minCost[next] = dis+1;
					visited[next] = true;
					pq.offer(new Edge(next, minCost[next]));
				}
			}
		}
		
		return visited;
	}
	
	static class Edge implements Comparable<Edge>{
		int end;
		int cost;
		Edge(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}