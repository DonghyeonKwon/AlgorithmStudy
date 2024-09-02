import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		List<Pos>[] list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new Pos(e, w));
//			list[e].add(new Pos(s, w));
		}
		
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		
		pq.offer(new Pos(k, 0));
		int cnt = 0;
		int[] minCost = new int[n+1];
		boolean[] visited = new boolean[n+1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[k] = 0;
		
		while(!pq.isEmpty()) {
//			System.out.println(Arrays.toString(minCost));
			Pos p = pq.poll();
			int e = p.e;
			int w = p.w;
			
			if(visited[e]) continue;
			visited[e] = true;
			cnt++;
			if(cnt == n) break;
			
			for(Pos next : list[e]) {
				if(visited[next.e]) continue;
				if(minCost[next.e] > minCost[e] + next.w) {
					minCost[next.e] = minCost[e] + next.w;
					pq.add(new Pos(next.e, minCost[next.e]));
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(minCost[i] == Integer.MAX_VALUE) {
				bw.write("INF\n");
				continue;
			}
			bw.write(Integer.toString(minCost[i]));
			bw.append('\n');
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Pos implements Comparable<Pos>{
		int e, w;
		Pos(int e, int w){
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Pos o) {
			return this.w - o.w;
		}
	}
}
