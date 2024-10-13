import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		List<Edge>[] list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[s].add(new Edge(e, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[n+1];
		int[] minCost = new int[n+1];
		int cnt = 0;
		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[s] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(s, 0));
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int here = edge.end;
			int cost = edge.cost;
			
			if(visited[here]) continue;
			visited[here] = true;
			cnt++;
			
			if(cnt == n) break;
			
			for(Edge next : list[here]) {
				if(visited[next.end]) continue;
				if(minCost[next.end] > cost + next.cost) {
					minCost[next.end] = cost + next.cost;
					pq.offer(new Edge(next.end, minCost[next.end]));
				}
			}
		}
		
		System.out.println(minCost[e]);
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