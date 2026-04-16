import java.io.*;
import java.util.*;

public class Main {
	static int n, m, x;
	static List<Edge>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		int[][] res = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[s].add(new Edge(e, c));
		}
		
		for(int i = 1; i <= n; i++) {
			res[i] = dikstra(i);
		}
		
		int max = 0;
		for(int i = 1; i <= n; i++) {
			int sum = res[i][x] + res[x][i];
			max = max < sum ? sum : max;
		}
		
		System.out.println(max);
	}
	
	static int[] dikstra(int here) {
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] visited = new boolean[n+1];
		int cnt = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(here, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			here = edge.end;
			int cost = edge.cost;
			
			if(visited[here]) continue;
			visited[here] = true;
			cnt++;
			
			if(cnt == n) break;
			
			for(Edge next : list[here]) {
				if(visited[next.end]) continue;
				if(distance[next.end] > cost + next.cost) {
					distance[next.end] = cost + next.cost;
					pq.offer(new Edge(next.end, distance[next.end]));
				}
			}
		}
		
		return distance;
	}
	
	static class Edge implements Comparable<Edge> {
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