import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
//	static int[][] map;
	static List<Integer>[] list;
	static int[] v;
	static boolean flag = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new List[n];
		v = new int[n];
		
		for(int i = 0; i < n; i++) list[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		boolean flag = false;
		for(int i = 0; i < n && !flag; i++) {
			v[i] = 1;
			flag = dfs(i, i, 0);
			v[i] = 0;
		}
		
		if(flag) bw.write(1 + "\n");
		else bw.write(0 + "\n");
		
		bw.close();
	}
	
	static boolean dfs(int now, int start, int cnt) {
		if(cnt == 4) {
			return true;
		}
		
		if(cnt > 4) {
			return false;
		}
		
		boolean flag = false;

		for(Integer next : list[now]) {
			if(v[next] == 1) continue;
			
			v[next] = 1;
			flag |= dfs(next, start, cnt+1);
			v[next] = 0;
            if(flag) break;
		}

		return flag;
	}
}