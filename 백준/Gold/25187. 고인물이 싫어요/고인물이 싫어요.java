import java.io.*;
import java.util.*;

public class Main {
	static int N, M, Q;
	static int[] info;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		info = new int[N+1];
		parents = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			info[i] = Integer.parseInt(st.nextToken());
			parents[i] = -1;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			union(s, e);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Q; i++) {
			int s = Integer.parseInt(br.readLine());
			int p1 = findSet(s);
			int cnt = parents[p1] * -1;
			
			if(cnt - info[p1] < info[p1]) sb.append(1).append('\n');
			else sb.append(0).append('\n');
		}	
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int findSet(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a == b) return;
		
		if(parents[a] < parents[b]) {
			parents[a] += parents[b];
			parents[b] = a;
			
			info[a] += info[b];
		} else {
			parents[b] += parents[a];
			parents[a] = b;
			
			info[b] += info[a];
		}
	}
}