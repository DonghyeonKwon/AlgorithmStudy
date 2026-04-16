import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		map = new int[n+1][n+1];
		int cnt = 0;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for(int j = 1; j < k; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[a]++;
				cnt++;
				map[prev][a]++;
				prev = a;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) {
			if(arr[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int a = q.poll();
			sb.append(a).append("\n");
			
			for(int i = 1; i <= n; i++) {
				if(map[a][i] == 0) continue;
				arr[i] -= map[a][i];
				cnt -= map[a][i];
				map[a][i] = 0;
				if(arr[i] == 0) q.offer(i);
			}
		}
		
		if(cnt > 0) {
			sb = new StringBuilder();
			sb.append("0").append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}