import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n, cnt = 0, to = 1;
	static List<Set<Integer>> list = new ArrayList<>();
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) {
			list.add(new HashSet<>());
		}
		
		StringTokenizer st;
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		visited = new boolean[n+1];
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		dfs(1);
		
		if(cnt == n - 1) System.out.println("1");
		else System.out.println("0");
	}
	
	static void dfs(int from) {		
		if(visited[from] || to >= n) {
			return;
		}
		
		visited[from] = true;
		
//		for(int i : list.get(from)) {
//			System.out.print(i + " ");
//		}System.out.println();

		
		while(!list.get(from).isEmpty()) {
//			System.out.println("" + from + list.get(from).isEmpty());
//			for(int i : list.get(from)) {
//				System.out.print(i + " ");
//			}System.out.println();
			
			if(to >= n) break;
			if(list.get(from).contains(arr[to])) {
//				System.out.println(from + " -> " + arr[to]);
				list.get(from).remove(arr[to]);
				list.get(arr[to]).remove(from);
				cnt++;
				dfs(arr[to++]);
			}
			else break;
		}
		
	}
}