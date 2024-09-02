import java.io.*;
import java.util.*;

public class Main {
	static List<Pos>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Pos(e, w));
			list[e].add(new Pos(s, w));
		}
		
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		
		int mv, cnt = 0, cost = 0;
		int[] minEdge = new int[n+1];
		boolean[] visited = new boolean[n+1];
		pq.add(new Pos(1,0));
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		while(!pq.isEmpty()) {
			mv = -1;
			Pos p = pq.poll();
			mv = p.e;
			if(visited[mv]) continue;
			
			cnt++;
			cost += p.w;
			visited[mv] = true;
			if(cnt == n) break;
			
			for(Pos next : list[mv]) {
				if(visited[next.e]) continue;
				if(minEdge[next.e] > next.w) {
					pq.add(next);
				}
			}
		}
		
		bw.write(Integer.toString(cost));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Pos implements Comparable<Pos>{
		int e;
		int w;
		Pos(int e, int w){
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.w, o.w);
		}
	}
}