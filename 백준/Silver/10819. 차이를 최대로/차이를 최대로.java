import java.io.*;
import java.util.*;

public class Main {
	static int n, max = 0;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		visited = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			visited[i] = true;
			go(arr[i], 1, 0);
			visited[i] = false;
		}
		
		System.out.println(max);
	}
	
	static void go(int prev, int cnt, int sum) {		
		if(cnt == n) {
			if(max < sum) {
				max = sum;
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			int a = prev - arr[i];
			a = a < 0 ? -a: a;
			go(arr[i], cnt+1, sum + a);
			visited[i] = false;
		}
	}
}
